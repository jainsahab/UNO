package com.tw.uno.view;

import javax.swing.*;
import java.awt.*;

public class CardButton extends JButton {
    private Color color;
    private Sign sign;

    public CardButton(Color color, Sign sign) {
        this.color = color;
        this.sign = sign;
        this.setText(this.sign.toString());
        this.setBackground(color);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.ITALIC, 100));
        this.setPreferredSize(new Dimension(150, 200));
    }
}
