package com.github.cawtoz.onlinestore.ui.login;

import com.github.cawtoz.onlinestore.ui.login.button.SignUpButton;
import com.github.cawtoz.onlinestore.util.CustomTextField;
import com.github.cawtoz.onlinestore.util.CustomWindow;
import com.github.cawtoz.onlinestore.ui.login.button.LoginButton;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

@Getter
public class LoginWindow extends CustomWindow {

    private JLabel jLabelSquare;
    private List<CustomTextField> textFields = new ArrayList<>();
    private JLabel warningText;

    public LoginWindow() {
        setTitle("Login");
        setSize(600, 700);
        setSquare();
        setTitle();
        setButtons();
        setTextFields();
        setWarningText();
        setBackgroundImage("background.jpg");
        setLocationRelativeTo(null);
        setVisible(false);
    }

    public void setTitle() {
        JLabel title = new JLabel("Login");
        title.setBounds(180,  100, 300, 60);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        title.setForeground(new Color(141, 3, 197));
        jLabelSquare.add(title);
    }

    public void setWarningText() {
        warningText = new JLabel();
        warningText.setBounds(65,  300, 200, 30);
        warningText.setFont(new Font(warningText.getFont().getName(), Font.ITALIC, 13));
        warningText.setForeground(new Color(141, 3, 197));
        jLabelSquare.add(warningText);
    }

    public void setSquare() {
        URL imageURL = getClass().getClassLoader().getResource("table.png");
        if (imageURL != null) {
            Image scaledImage = new ImageIcon(imageURL).getImage().getScaledInstance(450, 550, Image.SCALE_SMOOTH);
            jLabelSquare = new JLabel(new ImageIcon(scaledImage));
            jLabelSquare.setBounds(70, 30, 450, 600);
            getJPanel().add(jLabelSquare);
        }
    }

    public void setButtons() {
        jLabelSquare.add(new LoginButton(this, 70, 420));
        jLabelSquare.add(new SignUpButton(this,230, 420));
    }

    public void setTextFields() {

        textFields.add(new CustomTextField(jLabelSquare, 45, 160, "Username", "Enter the Username", false));
        textFields.add(new CustomTextField(jLabelSquare, 45, 230, "Password", "Enter the Password", true));

        textFields.forEach(textField -> jLabelSquare.add(textField.getJLabel()));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
            }
        });

    }

}
