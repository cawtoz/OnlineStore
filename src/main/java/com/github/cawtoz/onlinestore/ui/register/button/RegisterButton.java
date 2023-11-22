package com.github.cawtoz.onlinestore.ui.register.button;

import com.github.cawtoz.onlinestore.database.dao.impl.CustomerDAO;
import com.github.cawtoz.onlinestore.model.Customer;
import com.github.cawtoz.onlinestore.model.enums.UserType;
import com.github.cawtoz.onlinestore.ui.login.LoginWindow;
import com.github.cawtoz.onlinestore.ui.register.RegisterWindow;
import com.github.cawtoz.onlinestore.util.CustomButton;
import com.github.cawtoz.onlinestore.util.CustomTextField;

import java.awt.*;
import java.util.List;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class RegisterButton extends CustomButton {

    private RegisterWindow registerWindow;
    private Customer customer;
    private String repeatPassword;

    public RegisterButton(RegisterWindow registerWindow, int x, int y) {
        this.registerWindow = registerWindow;
        setBounds(x, y, 140, 50);
        setImage("button.png", this.getWidth() + 10, this.getHeight() + 10);
        setLabelText("Register");
        addActionListener(e -> {

            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            setValues();
            String register = register();
            registerWindow.getWarningText().setText(register);

            if (register.equals("true")) {
                new CustomerDAO().create(customer);
                registerWindow.setVisible(false);
                new LoginWindow().setVisible(true);
            }

            setCursor(new Cursor(Cursor.HAND_CURSOR));

        });
    }

    public String register() {

        if (customer.getName().equals(" ")) return "Invalid name";
        if (!customer.getEmail().contains("@")) return "Invalid email";

        try {
            if (customer.getPhone().contains(" ") || customer.getPhone().length() < 6 || customer.getPhone().length() > 20) return "Invalid phone";
        } catch (NumberFormatException e) {
            return "Invalid phone";
        }

        if (customer.getUsername().contains(" ")) return "Invalid username";
        if (customer.getPassword().equals(" ") || !customer.getPassword().equals(repeatPassword)) return "Passwords do not match";

        for (Customer cm : new CustomerDAO().getAll()) {


            if (cm.getUsername().equals(customer.getUsername())) {
                return "The username " + customer.getUsername() + " already exists";
            }

            if (cm.getEmail().equals(customer.getEmail())) {
                return "There is already a registered user with this email";
            }

        }

        if (!registerWindow.getJCheckBox().isSelected()) {
            return "You must accept the terms of conditions to register";
        }

        return "true";

    }

    public void setValues() {
        List<CustomTextField> customTextFields = registerWindow.getCustomTextFields();
        repeatPassword = customTextFields.get(5).getText();
        customer = new Customer(
                1,
                customTextFields.get(0).getJTextField().getText(),
                "",
                customTextFields.get(2).getText(),
                customTextFields.get(1).getText(),
                customTextFields.get(3).getText(),
                customTextFields.get(4).getText(),
                UserType.USER
        );
    }
    
}
