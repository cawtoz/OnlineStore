package com.github.cawtoz.onlinestore.ui.create;

import com.github.cawtoz.onlinestore.model.enums.OrderStatus;
import com.github.cawtoz.onlinestore.model.enums.TableType;
import com.github.cawtoz.onlinestore.model.enums.UserType;
import com.github.cawtoz.onlinestore.ui.create.button.AcceptButton;
import com.github.cawtoz.onlinestore.ui.create.button.CancelButton;
import com.github.cawtoz.onlinestore.util.CustomDialog;
import com.github.cawtoz.onlinestore.util.CustomTextField;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

@Getter
public class CreateWindow extends CustomDialog {

    private JLabel jLabelSquare;
    private List<CustomTextField> customTextFields = new ArrayList<>();
    private JLabel warningText;
    private JComboBox jComboBoxUserType;
    private JComboBox jComboBoxStatus;
    private TableType tableType;

    public CreateWindow(TableType tableType) {
        this.tableType = tableType;
        setTitle("Create");
        setSize(1000, 700);
        setSquare();
        setTextTitle();
        setButtons();
        setTextFields(tableType);
        setWarningText();
        setBackgroundImage("background.jpg");
        setLocationRelativeTo(null);
        setVisible(false);
        setModal(true);
    }

    public void setTextTitle() {
        JLabel title = new JLabel(tableType.getName());
        title.setBounds(350,  100, 300, 60);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        title.setForeground(new Color(141, 3, 197));
        jLabelSquare.add(title);
    }

    public void setWarningText() {
        warningText = new JLabel();
        warningText.setBounds(90,  360, 400, 30);
        warningText.setFont(new Font(warningText.getFont().getName(), Font.ITALIC, 13));
        warningText.setForeground(new Color(141, 3, 197));
        jLabelSquare.add(warningText);
    }

    public void setSquare() {
        URL imageURL = getClass().getClassLoader().getResource("table.png");
        if (imageURL != null) {
            Image scaledImage = new ImageIcon(imageURL).getImage().getScaledInstance(850, 600, Image.SCALE_SMOOTH);
            jLabelSquare = new JLabel(new ImageIcon(scaledImage));
            jLabelSquare.setBounds(70, 15, 850, 650);
            getJPanel().add(jLabelSquare);
        }
    }

    public void setButtons() {
        jLabelSquare.add(new AcceptButton(this, 170, 450));
        jLabelSquare.add(new CancelButton(this, 530, 450));
    }

    public void setTextFields(TableType tableType) {

        switch (tableType) {
            case CUSTOMERS -> setCustomerFields();
            case PRODUCT -> setProductFields();
            case ORDERS -> setOrderFields();
            case ORDER_PRODUCTS -> setOrderProductFields();
        }

        customTextFields.forEach(textField -> jLabelSquare.add(textField.getJLabel()));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
            }
        });

    }

    public void setCustomerFields() {
        customTextFields.clear();
        customTextFields.add(new CustomTextField(jLabelSquare, 65, 150, "Name", "Enter the Name", false));
        customTextFields.add(new CustomTextField(jLabelSquare, 65, 220, "Email", "Enter the Email", false));
        customTextFields.add(new CustomTextField(jLabelSquare, 65, 290, "Phone", "Enter the Phone", false));
        customTextFields.add(new CustomTextField(jLabelSquare, 420, 150, "Username", "Enter the Username", false));
        customTextFields.add(new CustomTextField(jLabelSquare, 420, 220, "Password", "Enter the Password", true));
        setUserTypeComboBox();
    }

    public void setProductFields() {
        customTextFields.clear();
        customTextFields.add(new CustomTextField(jLabelSquare, 65, 200, "Name", "Enter the Name", false));
        customTextFields.add(new CustomTextField(jLabelSquare, 65, 270, "Price", "Enter the Price", false));
        customTextFields.add(new CustomTextField(jLabelSquare, 420, 200, "Stock", "Enter the Stock", false));
        customTextFields.add(new CustomTextField(jLabelSquare, 420, 270, "Description", "Enter the Description", false));
    }

    public void setOrderFields() {
        customTextFields.clear();
        customTextFields.add(new CustomTextField(jLabelSquare, 250, 150, "Customer Id", "Enter the Customer Id", false));
        customTextFields.add(new CustomTextField(jLabelSquare, 250, 220, "Date", "Enter the Date", false));
        setStatusComboBox();
    }

    public void setOrderProductFields() {
        customTextFields.clear();
        customTextFields.add(new CustomTextField(jLabelSquare, 250, 150, "Order Id", "Enter the Order Id", false));
        customTextFields.add(new CustomTextField(jLabelSquare, 250, 220, "Product Id", "Enter the Product Id", false));
        customTextFields.add(new CustomTextField(jLabelSquare, 250, 290, "Quantity", "Enter the Quantity", false));
    }


    public void setUserTypeComboBox() {

        JLabel userTypeText = new JLabel("Type");
        userTypeText.setBounds(440,  290, 400, 30);
        userTypeText.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
        userTypeText.setForeground(new Color(111, 110, 110));
        jLabelSquare.add(userTypeText);

        jComboBoxUserType = new JComboBox(UserType.values());
        jComboBoxUserType.setBounds(440, 318, 310, 35);
        jLabelSquare.add(jComboBoxUserType);
    }

    public void setStatusComboBox() {
        JLabel userTypeText = new JLabel("Status");
        userTypeText.setBounds(270,  290, 400, 30);
        userTypeText.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
        userTypeText.setForeground(new Color(111, 110, 110));
        jLabelSquare.add(userTypeText);

        jComboBoxStatus = new JComboBox(OrderStatus.values());
        jComboBoxStatus.setBounds(270, 318, 310, 35);
        jLabelSquare.add(jComboBoxStatus);
    }

}
