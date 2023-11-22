package com.github.cawtoz.onlinestore.ui.login.button;

import com.github.cawtoz.onlinestore.ui.login.LoginWindow;
import com.github.cawtoz.onlinestore.ui.register.RegisterWindow;
import com.github.cawtoz.onlinestore.util.CustomButton;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class SignUpButton extends CustomButton {

    public SignUpButton(LoginWindow loginButton, int x, int y) {
        setBounds(x, y, 140, 50);
        setImage("button.png", this.getWidth() + 10, this.getHeight() + 10);
        setLabelText("SignUp");
        addActionListener(e -> {
            loginButton.setVisible(false);
            new RegisterWindow().setVisible(true);
        });
    }
    
}
