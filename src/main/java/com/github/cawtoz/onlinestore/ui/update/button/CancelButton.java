package com.github.cawtoz.onlinestore.ui.update.button;

import com.github.cawtoz.onlinestore.ui.update.UpdateWindow;
import com.github.cawtoz.onlinestore.util.CustomButton;

public class CancelButton extends CustomButton {

    public CancelButton(UpdateWindow updateWindow, int x, int y) {
        setBounds(x, y, 140, 50);
        setImage("button.png", this.getWidth() + 10, this.getHeight() + 10);
        setLabelText("Cancel");
        this.addActionListener((e) -> updateWindow.setVisible(false));
    }

}
