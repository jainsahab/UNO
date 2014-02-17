package com.tw.uno.view;

import javax.swing.*;
import java.awt.*;

public class Card extends JButton {
    Color color;
    Sign sign;

    public Card(Color color, Sign sign) {
        this.color = color;
        this.sign = sign;
        this.setText(this.sign.toString());
        this.setBackground(color);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.ITALIC, 100));
        this.setPreferredSize(new Dimension(150, 200));
    }
}
