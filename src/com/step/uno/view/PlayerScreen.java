package com.step.uno.view;


import com.step.uno.model.Card;

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
}