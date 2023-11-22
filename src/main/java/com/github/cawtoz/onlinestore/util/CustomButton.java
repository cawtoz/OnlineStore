package com.github.cawtoz.onlinestore.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

/**
 * @author Carlos Torres
 * @github github.com/cawtoz
 * @Institute Unidades Tecnologicas de Santander
 */

public class CustomButton extends JButton {

    private final Color overlayColor = new Color(0, 0, 0, 50);
    private boolean isMouseOver = false;

    public CustomButton() {
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isMouseOver = true;
                repaint();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                isMouseOver = false;
                repaint();
            }
        });
    }

    public void setImage(String image) {
        setImage(image, getWidth(), getHeight());
    }

    public void setImage(String image, int width, int height) {
        URL imageURL = getClass().getClassLoader().getResource(image);
        if (imageURL != null) {
            ImageIcon imageIcon = new ImageIcon(imageURL);
            Image scaledImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

            setIcon(new ImageIcon(scaledImage));
            setBorderPainted(false);
            setContentAreaFilled(false);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isMouseOver) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(overlayColor);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.dispose();
        }
    }

    public void setLabelText(String text) {
        JLabel jLabel = new JLabel(text);
        jLabel.setForeground(Color.WHITE);
        Font labelFont = jLabel.getFont();
        jLabel.setFont(new Font(labelFont.getName(), Font.BOLD, labelFont.getSize() + 2));
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setVerticalAlignment(JLabel.CENTER);

        setLayout(new BorderLayout());
        add(jLabel, BorderLayout.CENTER);
    }

}

