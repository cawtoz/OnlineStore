package com.github.cawtoz.onlinestore.ui.update.button;

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
import com.github.cawtoz.onlinestore.ui.update.UpdateWindow;
import com.github.cawtoz.onlinestore.util.CustomButton;
import com.github.cawtoz.onlinestore.util.CustomTextField;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.util.List;

public class AcceptButton extends CustomButton {

    private UpdateWindow updateWindow;
    private JTable jTable;
    private int row;
    List<CustomTextField> customTextFields;

    public AcceptButton(UpdateWindow updateWindow, int x, int y) {
        this.updateWindow = updateWindow;
        setBounds(x, y, 140, 50);
        setImage("button.png", this.getWidth() + 10, this.getHeight() + 10);
        setLabelText("Accept");

        this.addActionListener((e) -> {

            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            customTextFields = this.updateWindow.getCustomTextFields();
            jTable = updateWindow.getDashboardWindow().getCurrentTable();
            row = jTable.getSelectedRow();

            if (row != -1) {
                switch (this.updateWindow.getTableType()) {
                    case CUSTOMERS ->  new CustomerDAO().update(buildCustomer());
                    case PRODUCT -> new ProductDAO().update(buildProduct());
                    case ORDERS -> new OrderDAO().update(buildOrder());
                    case ORDER_PRODUCTS -> new OrderProductDAO().update(buildOrderProduct());
                }

                this.updateWindow.getDashboardWindow().setTable();
                this.updateWindow.setVisible(false);
            }


            setCursor(new Cursor(Cursor.HAND_CURSOR));
        });

    }

    public Customer buildCustomer() {
        return new Customer(
                (int) jTable.getModel().getValueAt(row, 0),
                customTextFields.get(0).getJTextField().getText(),
                "",
                customTextFields.get(2).getText(),
                customTextFields.get(1).getText(),
                customTextFields.get(3).getText(),
                customTextFields.get(4).getText(),
                (UserType) updateWindow.getJComboBoxUserType().getSelectedItem()
        );
    }

    public Product buildProduct() {
        return new Product(
                (int) jTable.getModel().getValueAt(row, 0),
                customTextFields.get(0).getJTextField().getText(),
                Double.parseDouble(customTextFields.get(1).getJTextField().getText()),
                Integer.parseInt(customTextFields.get(2).getJTextField().getText()),
                customTextFields.get(3).getJTextField().getText()
        );
    }


    @SneakyThrows
    public Order buildOrder() {
        return new Order(
                (int) jTable.getModel().getValueAt(row, 0),
                Integer.parseInt(customTextFields.get(0).getJTextField().getText()),
                Date.valueOf(customTextFields.get(1).getJTextField().getText()),
                (OrderStatus) updateWindow.getJComboBoxStatus().getSelectedItem()
        );
    }

    public OrderProduct buildOrderProduct() {
        return new OrderProduct(
                (int) jTable.getModel().getValueAt(row, 0),
                Integer.parseInt(customTextFields.get(0).getJTextField().getText()),
                Integer.parseInt(customTextFields.get(1).getJTextField().getText()),
                Integer.parseInt(customTextFields.get(2).getJTextField().getText())
        );
    }


}
