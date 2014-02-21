package com.step.uno.view;

import com.step.uno.model.Colour;
import com.step.uno.model.Sign;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class CardButton extends JButton {
    private Colour colour;
    private Sign sign;

    public CardButton(Colour colour, Sign sign) {
        this.colour = colour;
        this.sign = sign;
        String printableSign = String.valueOf(sign);
        printableSign = printableSign.replaceAll("_"," ");
        super.setText(printableSign);
        super.setBackground(colour.getColor());
        super.setForeground(Color.WHITE);
        super.setFont(new Font("Arial", Font.ITALIC, 25));
        this.setPreferredSize(new Dimension(150, 200));
    }
}