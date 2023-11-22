package com.github.cawtoz.onlinestore.util;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

@Getter @Setter
public class CustomWindow extends JFrame {

    private final JPanel jPanel;

    public CustomWindow() {
        jPanel = new JPanel();
        setContentPane(jPanel);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIcon("logo.png");
    }

    public void setIcon(String image) {
        URL iconURL = getClass().getClassLoader().getResource(image);
        if (iconURL != null) {
            ImageIcon originalIcon = new ImageIcon(iconURL);
            Image scaledImage = originalIcon.getImage().getScaledInstance(1000, 1000, Image.SCALE_SMOOTH);
            setIconImage(new ImageIcon(scaledImage).getImage());
        }
    }

    public void setBackgroundImage(String image) {
        URL imageURL = getClass().getClassLoader().getResource(image);
        if (imageURL != null) {
            JLabel backgroundLabel = new JLabel(new ImageIcon(imageURL));
            backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
            getJPanel().add(backgroundLabel);
        }
    }

}
