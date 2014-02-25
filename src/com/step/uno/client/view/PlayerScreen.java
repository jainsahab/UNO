package com.step.uno.client.view;

import com.step.uno.client.ClientPlayer;
import com.step.uno.model.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerScreen extends JFrame implements ActionListener {
    private final Dimension screenSize;
    private TopPanel playerButtons;
    private DeckView deck;
    private BottomPanel cards;
    private LogPanel logPanel;
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
        deck.closedPile.addActionListener(this);
        deck.unoButton.addActionListener(this);
        add(deck, BorderLayout.CENTER);

        cards = new BottomPanel(500, 230);
        JScrollPane cardPane = new JScrollPane(cards);
        cardPane.setPreferredSize(new Dimension(300, 240));
        contentPane.add(cardPane, BorderLayout.SOUTH);
        logPanel = new LogPanel(new Dimension(400, 650));
        contentPane.add(logPanel, BorderLayout.EAST);
    }

    public void addCard(Card card, boolean enable) {
        CardButton button = new CardButton(card);
        button.setEnabled(enable);
        button.addActionListener(this);
        cards.addButton(button);
    }

    public void addPlayer(String playerText, boolean turn, ClientPlayer player) {
        PlayerButton playerButton = new PlayerButton(playerText, player);
        playerButton.setPreferredSize(new Dimension(175, 175));
        playerButton.addActionListener(this);
        playerButtons.addPlayerButton(playerButton);
    }

    public void updateOpenCard(Card openCard) {
        deck.updateOpenCard(openCard);
    }

    public void setScreenTitle(String title) {
        this.setTitle(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        listener.onAction(e);
    }

    public void clean() {
        for (Component component : playerButtons.getComponents()) {
            component.setVisible(false);
        }
        for (Component component : cards.getComponents()) {
            component.setVisible(false);
        }
    }

    public void enableClosedPile(boolean closedPile) {
        deck.enableClosedPile(closedPile);
    }


    public void updateLog(String currentLog) {
        logPanel.add(currentLog.toString());
    }

    public void updateCloseDeck(String text) {
        deck.closedPile.setText(text);
    }

    public void updateStatusHint(String message) {
        deck.updateStatusHint(message);
    }
}