package com.github.cawtoz.onlinestore.ui.dashboard.button;

import com.github.cawtoz.onlinestore.model.enums.TableType;
import com.github.cawtoz.onlinestore.util.CustomButton;
import com.github.cawtoz.onlinestore.ui.dashboard.DashboardWindow;

import java.awt.*;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class TableButton extends CustomButton {

    public TableButton(DashboardWindow dashboardWindow, TableType tableType, int x, int y) {
        setBounds(x, y, 160, 60);
        setImage("button.png", getWidth() + 30, getHeight() + 30);
        setLabelText(tableType.getName());
        addActionListener(e -> {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            dashboardWindow.remove(dashboardWindow.getJPanel());
            dashboardWindow.setTableType(tableType);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        });
    }

}
