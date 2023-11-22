package com.github.cawtoz.onlinestore.util;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URL;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

@Getter
public class CustomTextField {

    private final Container container;
    private final String title;
    private final String content;
    private JLabel jLabelTitle;
    private JTextField jTextField;
    private boolean isPassword;
    private final JLabel jLabel = new JLabel();

    public CustomTextField(Container container, int x, int y, String title, String content, boolean isPassword) {
        this.container = container;
        this.title = title;
        this.content = content;
        this.isPassword = isPassword;
        setTitle();
        setJTextField();
        setBounds();
        jLabel.setLocation(x, y);
    }

    private void setTitle() {
        jLabelTitle = new JLabel();
        jLabelTitle.setLayout(null);
        jLabelTitle.setForeground(new Color(90, 90, 90));
        jLabelTitle.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
        jLabelTitle.setSize(100, 30);
        jLabel.add(jLabelTitle);
    }

    private void setJTextField() {

        jTextField = (isPassword) ? new JPasswordField(content) : new JTextField(content);
        jTextField.setBorder(null);
        jTextField.setForeground(new Color(111, 110, 110));
        jTextField.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
        if (isPassword) ((JPasswordField) jTextField).setEchoChar((char) 0);
        jLabel.add(jTextField);

        jTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (jTextField.getText().equals(content)) {
                    jLabelTitle.setText(title);
                    jTextField.setText("");
                    if (isPassword) ((JPasswordField) jTextField).setEchoChar('•');
                    jTextField.setForeground(null);
                    jTextField.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (jTextField.getText().isEmpty()) {
                    jLabelTitle.setText("");
                    jTextField.setText(content);
                    if (isPassword) ((JPasswordField) jTextField).setEchoChar((char) 0);
                    jTextField.setForeground(new Color(111, 110, 110));
                    jTextField.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
                }
            }
        });

    }

    private void setBounds() {
        jLabel.setSize(350, 90);
        jLabelTitle.setLocation(20, 0);
        jTextField.setBounds(30, 30, 290, 30);
        setImage("field.png", 350, 65);
    }

    public void setImage(String image, int width, int height) {
        URL imageURL = getClass().getClassLoader().getResource(image);
        if (imageURL != null) {
            ImageIcon imageIcon = new ImageIcon(imageURL);
            Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            jLabel.setIcon(new ImageIcon(scaledImage));
            container.add(jLabel);
        }
    }

    public String getText() {
        return getJTextField().getText().equals(content) ? "" : getJTextField().getText();
    }


}
