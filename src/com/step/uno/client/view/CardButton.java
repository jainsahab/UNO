package com.step.uno.client.view;

import com.step.uno.model.Card;

import javax.swing.*;
import java.awt.*;

public class CardButton extends JButton {

    private Card card;

    public CardButton(Card card) {
        this.card = card;
        String printableSign = String.valueOf(card.sign);
        printableSign = printableSign.replaceAll("_", " ");
        this.setText(printableSign);
        this.setForeground(Color.LIGHT_GRAY);
        this.setBackground(card.colour.getColor());
        this.setFont(new Font("Arial", Font.ITALIC, 30));
        this.setPreferredSize(new Dimension(150, 200));

    }

    public Card getCard() {
        return card;
    }
}