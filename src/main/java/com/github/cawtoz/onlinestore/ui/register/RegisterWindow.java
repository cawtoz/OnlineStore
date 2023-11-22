package com.github.cawtoz.onlinestore.ui.register;

import com.github.cawtoz.onlinestore.ui.register.button.BackButton;
import com.github.cawtoz.onlinestore.ui.register.button.RegisterButton;
import com.github.cawtoz.onlinestore.util.CustomTextField;
import com.github.cawtoz.onlinestore.util.CustomWindow;
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
public class RegisterWindow extends CustomWindow {

    private JLabel jLabelSquare;
    private List<CustomTextField> customTextFields = new ArrayList<>();
    private JCheckBox jCheckBox;
    private JLabel warningText;

    public RegisterWindow() {
        setTitle("Register");
        setSize(1000, 700);
        setSquare();
        setTitle();
        setButtons();
        setTextFields();
        setCheckBox();
        setWarningText();
        setBackgroundImage("background.jpg");
        setLocationRelativeTo(null);
        setVisible(false);
    }

    public void setCheckBox() {
        jCheckBox = new JCheckBox("I accept the terms and conditions");
        jCheckBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        jCheckBox.setBounds(460, 365, 300, 30);
        jLabelSquare.add(jCheckBox);
    }

    public void setTitle() {
        JLabel title = new JLabel("Register");
        title.setBounds(350,  100, 300, 60);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        title.setForeground(new Color(141, 3, 197));
        jLabelSquare.add(title);
    }

    public void setWarningText() {
        warningText = new JLabel();
        warningText.setBounds(90,  360, 400, 30);
        warningText.setFont(new Font(warningText.getFont().getName(), Font.ITALIC, 13));
        warningText.setForeground(new Color(141, 3, 197));
        jLabelSquare.add(warningText);
    }

    public void setSquare() {
        URL imageURL = getClass().getClassLoader().getResource("table.png");
        if (imageURL != null) {
            Image scaledImage = new ImageIcon(imageURL).getImage().getScaledInstance(850, 600, Image.SCALE_SMOOTH);
            jLabelSquare = new JLabel(new ImageIcon(scaledImage));
            jLabelSquare.setBounds(70, 15, 850, 650);
            getJPanel().add(jLabelSquare);
        }
    }

    public void setButtons() {
        jLabelSquare.add(new RegisterButton(this, 170, 450));
        jLabelSquare.add(new BackButton(this, 530, 450));
    }

    public void setTextFields() {

        customTextFields.add(new CustomTextField(jLabelSquare, 65, 150, "Name", "Enter the Name", false));
        customTextFields.add(new CustomTextField(jLabelSquare, 65, 220, "Email", "Enter the Email", false));
        customTextFields.add(new CustomTextField(jLabelSquare, 65, 290, "Phone", "Enter the Phone", false));

        customTextFields.add(new CustomTextField(jLabelSquare, 420, 150, "Username", "Enter the Username", false));
        customTextFields.add(new CustomTextField(jLabelSquare, 420, 220, "Password", "Enter the Password", true));
        customTextFields.add(new CustomTextField(jLabelSquare, 420, 290, "Password", "Repeat the Password", true));

        customTextFields.forEach(textField -> jLabelSquare.add(textField.getJLabel()));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
            }
        });

    }

}
