package com.github.cawtoz.onlinestore.ui.register.button;

import com.github.cawtoz.onlinestore.util.CustomButton;
import com.github.cawtoz.onlinestore.ui.login.LoginWindow;
import com.github.cawtoz.onlinestore.ui.register.RegisterWindow;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class BackButton extends CustomButton {
    
    public BackButton(RegisterWindow registerWindow, int x, int y) {
        setBounds(x, y, 140, 50);
        setImage("button.png", this.getWidth() + 10, this.getHeight() + 10);
        setLabelText("Back");
        addActionListener(e -> {
            registerWindow.setVisible(false);
            new LoginWindow().setVisible(true);
        });
    }
    
}
