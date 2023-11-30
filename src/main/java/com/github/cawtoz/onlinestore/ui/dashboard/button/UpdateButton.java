package com.github.cawtoz.onlinestore.ui.dashboard.button;

import com.github.cawtoz.onlinestore.ui.update.UpdateWindow;
import com.github.cawtoz.onlinestore.util.CustomButton;
import com.github.cawtoz.onlinestore.ui.dashboard.DashboardWindow;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class UpdateButton extends CustomButton {

    public UpdateButton(DashboardWindow dashboardWindow, int x, int y) {
        setBounds(x, y, 50, 50);
        setImage("edit.png", getWidth() + 10, getHeight() + 10);
        addActionListener((e) -> new UpdateWindow(dashboardWindow).setVisible(true));
    }

}
