package com.step.uno.client.view;

import com.step.uno.model.Card;

import javax.swing.*;
import java.awt.*;

public class DeckView extends JPanel {

    public OpenedPile openedPile;
    public ClosedPile closedPile;
    public UnoButton unoButton;

    public DeckView(Dimension size) {
        setBackground(Color.decode("#BAB3AB"));
        setLayout(new GridLayout(2, 2));
        setSize(size);
        setVisible(true);
        openedPile = new OpenedPile();
        closedPile = new ClosedPile();
        unoButton = new UnoButton();
        JLabel statusHint = new JLabel("This is hint");
        add(closedPile);
        add(openedPile);
        add(statusHint);
        add(unoButton);
    }

    public DeckView() {
        this(new Dimension(500, 500));
    }

    public void updateOpenCard(Card card) {
        openedPile.updateCardOnOpenPile(card.colour, card.sign);
    }

    public void enableClosedPile(boolean enable) {
        closedPile.setEnabled(enable);
    }

}
