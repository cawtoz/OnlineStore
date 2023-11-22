package com.github.cawtoz.onlinestore.ui.dashboard.button;

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
import com.github.cawtoz.onlinestore.util.CustomButton;
import com.github.cawtoz.onlinestore.ui.dashboard.DashboardWindow;
import com.github.cawtoz.onlinestore.ui.dashboard.table.Table;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.sql.Date;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class UpdateButton extends CustomButton {

    public UpdateButton(DashboardWindow dashboardWindow, int x, int y) {

        setBounds(x, y, 50, 50);
        setImage("edit.png", getWidth() + 10, getHeight() + 10);

        addActionListener(e -> {

            Table table = dashboardWindow.getCurrentTable();
            JTable jTable = dashboardWindow.getCurrentTable();
            int selectedRow = jTable.getSelectedRow();

            if (selectedRow != -1) {
                TableModel model = jTable.getModel();
                switch (table.getName()) {
                    case "customers" -> new CustomerDAO().update(buildCustomer(model, selectedRow));
                    case "products" -> new ProductDAO().update(buildProduct(model, selectedRow));
                    case "orders" -> new OrderDAO().update(buildOrder(model, selectedRow));
                    case "order_products" -> new OrderProductDAO().update(buildOrderProduct(model, selectedRow));
                }
            }

        });

    }

    public Customer buildCustomer(TableModel model, int row) {
        return new Customer(
                (int) model.getValueAt(row, 0),
                (String) model.getValueAt(row, 1),
                (String) model.getValueAt(row, 2),
                (String) model.getValueAt(row, 3),
                (String) model.getValueAt(row, 4),
                (String) model.getValueAt(row, 5),
                (String) model.getValueAt(row, 6),
                UserType.valueOf(model.getValueAt(row, 7).toString())
        );
    }

    public Product buildProduct(TableModel model, int row) {
        return new Product(
                (int) model.getValueAt(row, 0),
                (String) model.getValueAt(row, 1),
                (double) model.getValueAt(row, 2),
                (int) model.getValueAt(row, 3),
                (String) model.getValueAt(row, 4)
        );
    }

    public Order buildOrder(TableModel model, int row) {
        return new Order(
                (int) model.getValueAt(row, 0),
                (int) model.getValueAt(row, 1),
                (Date) model.getValueAt(row, 2),
                OrderStatus.valueOf(model.getValueAt(row, 3).toString())
        );
    }

    public OrderProduct buildOrderProduct(TableModel model, int row) {
        return new OrderProduct(
                (int) model.getValueAt(row, 0),
                (int) model.getValueAt(row, 1),
                (int) model.getValueAt(row, 2),
                (int) model.getValueAt(row, 3)
        );
    }

}
