package com.tw.uno.view;

import javax.swing.*;

public class Card extends JButton{
    String color;
    String sign;

    public Card(String color, String sign) {
        this.color = color;
        this.sign = sign;
        super.setText(sign);
    }
}
