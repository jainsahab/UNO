package com.step.uno.view;
import com.step.uno.model.Card;

import javax.swing.*;
import java.awt.*;
public class DeckView extends JPanel {

    public OpenedPile openedPile;
    public ClosedPile closedPile;

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

        Button unoButton = new Button("UNO");
        unoButton.setPreferredSize(new Dimension(100, 100));
        unoButton.setBackground(Color.ORANGE);
        add(unoButton);
    }

    public DeckView() {
        this(new Dimension(500, 500));
    }

    public void updateOpenCard(Card card) {
        openedPile.updateCardOnOpenPile(card.colour,card.sign);
    }

    public void setClosedPile(boolean enable) {
        closedPile.setEnabled(enable);
    }
}
