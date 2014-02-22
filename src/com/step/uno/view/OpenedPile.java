package com.step.uno.view;

import com.step.uno.model.Colour;
import com.step.uno.model.Sign;

import javax.swing.*;
import java.awt.*;

public class OpenedPile extends JButton {
    public OpenedPile() {
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.ITALIC, 30));
        this.setPreferredSize(new Dimension(200, 220));
        this.setVisible(true);
        this.setEnabled(false);
    }
    public void updateCardOnOpenPile(Colour colour,Sign sign){
        String printableSign = String.valueOf(sign);
        printableSign = printableSign.replaceAll("_"," ");
        this.setText(printableSign);
        this.setBackground(colour.getColor());
    }
}
