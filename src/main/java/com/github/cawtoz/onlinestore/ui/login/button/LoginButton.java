package com.github.cawtoz.onlinestore.ui.login.button;

import com.github.cawtoz.onlinestore.database.dao.impl.CustomerDAO;
import com.github.cawtoz.onlinestore.model.Customer;
import com.github.cawtoz.onlinestore.ui.dashboard.DashboardWindow;
import com.github.cawtoz.onlinestore.ui.login.LoginWindow;
import com.github.cawtoz.onlinestore.util.CustomButton;

import java.awt.*;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class LoginButton extends CustomButton {
    private LoginWindow loginWindow;

    public LoginButton(LoginWindow loginWindow, int x, int y) {
        this.loginWindow = loginWindow;
        setBounds(x, y, 140, 50);
        setImage("button.png", this.getWidth() + 10, this.getHeight() + 10);
        setLabelText("Login");

        this.addActionListener((e) -> {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            String login = this.login();
            loginWindow.getWarningText().setText(login);

            if (login.equals("true")) {
                loginWindow.setVisible(false);
                new DashboardWindow().setVisible(true);
            }

            setCursor(new Cursor(Cursor.HAND_CURSOR));
        });

    }

    public String login() {

        String username = loginWindow.getTextFields().get(0).getJTextField().getText();
        String password = loginWindow.getTextFields().get(1).getJTextField().getText();

        for (Customer customer : new CustomerDAO().getAll()) {
            if (customer.getUsername().equals(username)) {
                return customer.getPassword().equals(password) ? "true" : "Incorrect password";
            }
        }
        return "Username does not exist";

    }
}