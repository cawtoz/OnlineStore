package com.github.cawtoz.onlinestore.ui.dashboard.button;

import com.github.cawtoz.onlinestore.util.CustomButton;
import com.github.cawtoz.onlinestore.ui.dashboard.DashboardWindow;
import com.github.cawtoz.onlinestore.ui.login.LoginWindow;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class LogoutButton extends CustomButton {

    public LogoutButton(DashboardWindow dashboardWindow, int x, int y) {
        setBounds(x, y, 160, 60);
        setImage("button.png", getWidth() + 30, getHeight() + 30);
        setLabelText("Logout");
        addActionListener(e -> {
            dashboardWindow.setVisible(false);
            new LoginWindow().setVisible(true);
        });
    }

}
