package com.step.uno.client.view;

import com.step.uno.model.Card;

import javax.swing.*;
import java.awt.*;

public class DeckView extends JPanel {

    public OpenedPile openedPile;
    public ClosedPile closedPile;
    public UnoButton unoButton;
    public StatusHint statusHint;

    public DeckView(Dimension size) {
        setBackground(Color.decode("#BAB3AB"));
        setSize(size);
        setVisible(true);
        this.setLayout(null);
        openedPile = new OpenedPile();
        openedPile.setPreferredSize(new Dimension(150, 200));
        openedPile.setBounds(400, 100, 150, 200);

        closedPile = new ClosedPile();
        closedPile.setBounds(700, 100, 150, 200);
        closedPile.setPreferredSize(new Dimension(150, 200));


        unoButton = new UnoButton("UNO");
        unoButton.setBounds(1100, 400, 200, 200);

        statusHint = new StatusHint();
        statusHint.setBounds(500, 400, 400, 100);

        this.add(closedPile);
        this.add(openedPile);
        this.add(unoButton);
        this.add(statusHint);
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
