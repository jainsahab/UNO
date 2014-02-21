package com.step.uno.view;

import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.model.Sign;

import javax.swing.*;
import java.awt.*;

public class CardButton extends JButton {

    private Card card;

    public CardButton(Card card) {
        this.card = card;
        String printableSign = String.valueOf(card.sign);
        printableSign = printableSign.replaceAll("_"," ");
        super.setText(printableSign);
        super.setBackground(card.colour.getColor());
        super.setForeground(Color.WHITE);
        super.setFont(new Font("Arial", Font.ITALIC, 25));
        this.setPreferredSize(new Dimension(150, 200));
    }

    public Card getCard() {
        return card;
    }
}