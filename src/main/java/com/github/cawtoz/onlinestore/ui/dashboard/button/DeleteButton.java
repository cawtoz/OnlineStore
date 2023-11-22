package com.github.cawtoz.onlinestore.ui.dashboard.button;

import com.github.cawtoz.onlinestore.database.dao.impl.CustomerDAO;
import com.github.cawtoz.onlinestore.database.dao.impl.OrderDAO;
import com.github.cawtoz.onlinestore.database.dao.impl.OrderProductDAO;
import com.github.cawtoz.onlinestore.database.dao.impl.ProductDAO;
import com.github.cawtoz.onlinestore.util.CustomButton;
import com.github.cawtoz.onlinestore.ui.dashboard.DashboardWindow;

import javax.swing.*;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class DeleteButton extends CustomButton {

    public DeleteButton(DashboardWindow dashboardWindow, int x, int y) {
        setBounds(x, y, 50, 50);
        setImage("delete.png");
        addActionListener(e -> {
            JTable jTable = dashboardWindow.getCurrentTable();
            for (int row : jTable.getSelectedRows()) {
                if (row != -1) {
                    int id = (int) jTable.getModel().getValueAt(row, 0);
                    System.out.println(id);
                    switch (dashboardWindow.getCurrentTable().getName()) {
                        case "customers" -> new CustomerDAO().delete(id);
                        case "products" -> new ProductDAO().delete(id);
                        case "orders" -> new OrderDAO().delete(id);
                        case "order_products" -> new OrderProductDAO().delete(id);
                    }
                }
            }
            dashboardWindow.setTable();
        });
    }

}
