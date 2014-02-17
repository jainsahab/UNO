package com.tw.uno.view;

import javax.swing.*;
import java.awt.*;

public class Card extends JButton {
    Color color;
    String sign;

    public Card(Color color, String sign) {
        this.color = color;
        this.sign = sign;
        super.setText(sign);
        super.setBackground(color);
        super.setForeground(Color.WHITE);
        super.setFont(new Font("Arial", Font.ITALIC, 100));
        this.setPreferredSize(new Dimension(150, 200));
    }
}
