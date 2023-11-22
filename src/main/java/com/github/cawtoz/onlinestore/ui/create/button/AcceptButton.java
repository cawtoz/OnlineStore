package com.github.cawtoz.onlinestore.ui.create.button;

import com.github.cawtoz.onlinestore.database.dao.impl.CustomerDAO;
import com.github.cawtoz.onlinestore.database.dao.impl.OrderDAO;
import com.github.cawtoz.onlinestore.database.dao.impl.OrderProductDAO;
import com.github.cawtoz.onlinestore.database.dao.impl.ProductDAO;
import com.github.cawtoz.onlinestore.model.Customer;
import com.github.cawtoz.onlinestore.model.Order;
import com.github.cawtoz.onlinestore.model.OrderProduct;
import com.github.cawtoz.onlinestore.model.Product;
import com.github.cawtoz.onlinestore.model.enums.OrderStatus;
import com.github.cawtoz.onlinestore.model.enums.UserType;
import com.github.cawtoz.onlinestore.ui.create.CreateWindow;
import com.github.cawtoz.onlinestore.util.CustomButton;
import com.github.cawtoz.onlinestore.util.CustomTextField;
import lombok.SneakyThrows;

import java.awt.*;
import java.sql.Date;
import java.util.List;

public class AcceptButton extends CustomButton {

    private CreateWindow createWindow;
    List<CustomTextField> customTextFields;

    public AcceptButton(CreateWindow createWindow, int x, int y) {
        this.createWindow = createWindow;
        setBounds(x, y, 140, 50);
        setImage("button.png", this.getWidth() + 10, this.getHeight() + 10);
        setLabelText("Accept");
        this.addActionListener((e) -> {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            customTextFields = createWindow.getCustomTextFields();

            switch (createWindow.getTableType()) {
                case CUSTOMERS ->  new CustomerDAO().create(buildCustomer());
                case PRODUCT -> new ProductDAO().create(buildProduct());
                case ORDERS -> new OrderDAO().create(buildOrder());
                case ORDER_PRODUCTS -> new OrderProductDAO().create(buildOrderProduct());
            }

            createWindow.getDashboardWindow().setTable();
            createWindow.setVisible(false);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        });
    }

    public Customer buildCustomer() {
        return new Customer(
                1,
                customTextFields.get(0).getJTextField().getText(),
                "",
                customTextFields.get(2).getText(),
                customTextFields.get(1).getText(),
                customTextFields.get(3).getText(),
                customTextFields.get(4).getText(),
                (UserType) createWindow.getJComboBoxUserType().getSelectedItem()
        );
    }

    public Product buildProduct() {
        return new Product(
                1,
                customTextFields.get(0).getJTextField().getText(),
                Double.parseDouble(customTextFields.get(1).getJTextField().getText()),
                Integer.parseInt(customTextFields.get(2).getJTextField().getText()),
                customTextFields.get(3).getJTextField().getText()
        );
    }


    @SneakyThrows
    public Order buildOrder() {
        return new Order(
                1,
                Integer.parseInt(customTextFields.get(0).getJTextField().getText()),
                Date.valueOf(customTextFields.get(1).getJTextField().getText()),
                (OrderStatus) createWindow.getJComboBoxStatus().getSelectedItem()
        );
    }

    public OrderProduct buildOrderProduct() {
        return new OrderProduct(
                1,
                Integer.parseInt(customTextFields.get(0).getJTextField().getText()),
                Integer.parseInt(customTextFields.get(1).getJTextField().getText()),
                Integer.parseInt(customTextFields.get(2).getJTextField().getText())
        );
    }


}
