package com.step.uno.view;


import com.step.uno.model.Card;
import com.step.uno.model.PlayerSummary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerScreen extends JFrame implements ActionListener {
    private final Dimension screenSize;
    private TopPanel playerButtons;
    private DeckView deck;
    private BottomPanel cards;
    private LogPanel log;
    private UnoViewListener listener;

    public PlayerScreen(UnoViewListener listener) {
        this.listener = listener;
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("UNO");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(screenSize);

        playerButtons = new TopPanel();

        playerButtons.setBackground(Color.BLACK);

        JScrollPane playerPane = new JScrollPane(playerButtons);
        playerPane.setPreferredSize(new Dimension(500, 230));
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.add(playerPane, BorderLayout.NORTH);

        deck = new DeckView();
        deck.closedPile.addActionListener(this);
        add(deck, BorderLayout.CENTER);

        cards = new BottomPanel(500, 230);
        JScrollPane cardPane = new JScrollPane(cards);
        cardPane.setPreferredSize(new Dimension(300, 240));
        contentPane.add(cardPane, BorderLayout.SOUTH);

        log = new LogPanel();
        log.setPreferredSize(new Dimension(300, 800));
        add(log, BorderLayout.EAST);
    }

    public void addCard(Card card, boolean enable) {
        CardButton button = new CardButton(card);
        button.setEnabled(enable);
        button.addActionListener(this);
        cards.addButton(button);
    }

    public void updatePlayer(PlayerSummary playerSummary, boolean turn) {
        PlayerButton playerButton = new PlayerButton(playerSummary.name, playerSummary.cardsInHand);
        if (turn) playerButton.setBackground(Color.green);
        playerButtons.addPlayerButton(playerButton);
    }

    public void updateOpenCard(Card openCard) {
        deck.updateOpenCard(openCard);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.getClass().equals(CardButton.class)) {
            listener.cardPlayed(((CardButton) source).getCard());
        }
        if (source.getClass().equals(ClosedPile.class))
            listener.cardDrawn();
    }

    public void clean() {
        playerButtons.removeAll();
        for (Component component : cards.getComponents()) {
            component.setVisible(false);
        }
    }

    public void setClosedPile(boolean closedPile) {
        deck.setClosedPile(closedPile);
    }
}