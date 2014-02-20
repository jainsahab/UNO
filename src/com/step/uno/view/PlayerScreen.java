package com.step.uno.view;


import com.step.uno.model.Card;
import com.step.uno.model.PlayerSummary;

import javax.swing.*;
import java.awt.*;

public class PlayerScreen extends JFrame {
    private final Dimension screenSize;
    private TopPanel playerButtons;
    private DeckView deck;
    private BottomPanel cards;
    private LogPanel log;

    public PlayerScreen() {
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
        add(deck, BorderLayout.CENTER);

        cards = new BottomPanel(500, 230);
        JScrollPane cardPane = new JScrollPane(cards);
        cardPane.setPreferredSize(new Dimension(300, 240));
        contentPane.add(cardPane, BorderLayout.SOUTH);

        log = new LogPanel();
        log.setPreferredSize(new Dimension(300, 800));
        add(log, BorderLayout.EAST);
    }

    public void addMyCard(Card card) {

    }

    public void addCard(Card myCard) {
        cards.add(new JButton(myCard.colour.toString() + " " + myCard.sign.toString()));
    }

    public void addPlayer(PlayerSummary playerSummary) {
        playerButtons.addPlayerButton(new PlayerButton(playerSummary.name,playerSummary.cardsInHand));
    }

    public void updateOpenCard(Card openCard) {
        deck.updateOpenCard(openCard);
    }
}