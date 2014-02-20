package com.step.uno.view;

import com.step.uno.model.Card;

import javax.swing.*;
import java.awt.*;

public class DeckView extends JPanel {

    private OpenedPile openedPile;
    private ClosedPile closedPile;

    public DeckView(Dimension size) {
        setBackground(Color.gray);
        setLayout(new GridLayout(2, 2));
        setSize(size);
        setVisible(true);
        openedPile = new OpenedPile();
        add(openedPile);
        closedPile = new ClosedPile();
        add(closedPile);
        JLabel statusHint = new JLabel("This is hint");
        add(statusHint);
    }

    public DeckView() {
        this(new Dimension(500, 500));
    }


    public void updateOpenCard(Card card) {
        openedPile.setText(card.colour.toString() + " " + card.sign.toString());
    }
}
