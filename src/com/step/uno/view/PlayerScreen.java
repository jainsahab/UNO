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

    public void addCard(Card myCard, boolean enable) {
        CardButton button = new CardButton(myCard);
        button.setEnabled(enable);
        button.addActionListener(this);
        cards.addButton(button);
    }

    public void addPlayer(PlayerSummary playerSummary, boolean turn) {
        PlayerButton playerButton = new PlayerButton(playerSummary.name, playerSummary.cardsInHand);
        if (turn) playerButton.setBackground(Color.green);
        playerButtons.addPlayerButton(playerButton);
    }

    public void updateOpenCard(Card openCard) {
        deck.updateOpenCard(openCard);
    }

    public void setScreenTitle(String title){
        this.setTitle(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.getClass().equals(CardButton.class)) {
            listener.cardPlayed(((CardButton) source).getCard());
        }
    }

    public void clean() {
        removeComponents(playerButtons);
        removeComponents(cards);
    }

    private void removeComponents(JPanel panel) {
        for (Component component : panel.getComponents()) {
            panel.remove(component);
        }
    }
}