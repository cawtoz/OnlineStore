package com.github.cawtoz.onlinestore.ui.dashboard;

import com.github.cawtoz.onlinestore.model.enums.TableType;
import com.github.cawtoz.onlinestore.util.CustomWindow;
import com.github.cawtoz.onlinestore.ui.dashboard.button.*;
import com.github.cawtoz.onlinestore.ui.dashboard.table.Table;
import com.github.cawtoz.onlinestore.ui.dashboard.table.impl.CustomersTable;
import com.github.cawtoz.onlinestore.ui.dashboard.table.impl.OrderProductsTable;
import com.github.cawtoz.onlinestore.ui.dashboard.table.impl.OrdersTable;
import com.github.cawtoz.onlinestore.ui.dashboard.table.impl.ProductsTable;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

@Getter @Setter
public class DashboardWindow extends CustomWindow {

    private final Color tableColor = new Color(78, 88, 137);
    private int tableX = 280, tableY = 100, tableWidth = 900, tableHeight = 300;
    private Table currentTable;
    private JLabel tableText;
    private JLabel tableBackgroundImage;
    private JLabel tableImage;
    private TableType tableType;

    public DashboardWindow() {
        setTitle("Dashboard");
        setSize(1280, 720);
        setButtons();
        setCrudTexts();
        setTableBackgroundImage();
        setBackgroundImage("background.jpg");
        setTableText();
        setTableType(TableType.CUSTOMERS);
        setLocationRelativeTo(null);
        setVisible(false);
    }

    public void setTableType(TableType tableType) {
        this.tableType = tableType;
        setTable();
    }

    public void setTableText() {
        if (tableText != null) getJPanel().remove(tableText);
        tableText = new JLabel();
        tableText.setBounds(150, 110, 300, 30);
        tableText.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        tableText.setForeground(new Color(141, 3, 197));
        tableBackgroundImage.add(tableText);
    }

    public void setCrudTexts() {

        JLabel[] crudTexts = new JLabel[] {
                new JLabel("Create"),
                new JLabel("Update"),
                new JLabel("Delete")
        };

        crudTexts[0].setLocation(505, 560);
        crudTexts[1].setLocation(705, 560);
        crudTexts[2].setLocation(905, 560);

        for (JLabel crudText : crudTexts) {
            crudText.setSize(100, 20);
            crudText.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            crudText.setForeground(new Color(141, 3, 197));
            add(crudText);
        }


    }

    public void setTableImage(TableType tableType) {

        String image = "";
        switch (tableType) {
            case CUSTOMERS -> image = "customers.png";
            case PRODUCT -> image = "product.png";
            case ORDERS -> image = "order.png";
            case ORDER_PRODUCTS -> image = "order_product.png";
        }

        URL imageURL = getClass().getClassLoader().getResource(image);
        if (imageURL != null) {
            if (tableImage != null) tableBackgroundImage.remove(tableImage);
            Image scaledImage = new ImageIcon(imageURL).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            tableImage = new JLabel(new ImageIcon(scaledImage));
            tableImage.setBounds(90, 103, 50, 50);
            tableBackgroundImage.add(tableImage);
        }
    }

    public void setTableBackgroundImage() {
        URL imageURL = getClass().getClassLoader().getResource("table.png");
        if (imageURL != null) {
            Image scaledImage = new ImageIcon(imageURL).getImage().getScaledInstance(1050, 750, Image.SCALE_SMOOTH);
            tableBackgroundImage = new JLabel(new ImageIcon(scaledImage));
            tableBackgroundImage.setBounds(225, -25, 1050, 750);
            getJPanel().add(tableBackgroundImage);
        }
    }

    public void setButtons() {
        getJPanel().add(new TableButton(this, TableType.CUSTOMERS, 60, 120));
        getJPanel().add(new TableButton(this, TableType.PRODUCT, 60, 200));
        getJPanel().add(new TableButton(this, TableType.ORDERS, 60, 280));
        getJPanel().add(new TableButton(this, TableType.ORDER_PRODUCTS, 60, 360));
        getJPanel().add(new LogoutButton(this, 60, 510));
        getJPanel().add(new CreateButton( this, 510, 500));
        getJPanel().add(new UpdateButton(this, 710, 500));
        getJPanel().add(new DeleteButton(this, 910, 500));
    }

    public void setTable() {

        if (currentTable != null) {
            tableBackgroundImage.remove(currentTable.getJPanel());
            tableBackgroundImage.repaint();
        }

        currentTable = switch (tableType) {
            case CUSTOMERS -> new CustomersTable();
            case PRODUCT -> new ProductsTable();
            case ORDERS -> new OrdersTable();
            case ORDER_PRODUCTS -> new OrderProductsTable();
        };

        currentTable.putInContainer(tableBackgroundImage, 70, 170, tableWidth, tableHeight);
        tableText.setText(tableType.getName());
        setTableImage(tableType);
        setVisible(true);

    }

}
