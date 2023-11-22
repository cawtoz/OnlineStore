package com.github.cawtoz.onlinestore.ui.dashboard.button;

import com.github.cawtoz.onlinestore.ui.create.CreateWindow;
import com.github.cawtoz.onlinestore.ui.dashboard.DashboardWindow;
import com.github.cawtoz.onlinestore.util.CustomButton;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class CreateButton extends CustomButton {

    public CreateButton(DashboardWindow dashboardWindow, int x, int y) {
        setBounds(x, y, 50, 50);
        setImage("add.png");
        addActionListener((e) -> new CreateWindow(dashboardWindow).setVisible(true));
    }

}
