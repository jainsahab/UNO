package com.tw.uno.view;


import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    private final Dimension screenSize;

    public Screen() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("UNO");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(screenSize);
        setVisible(true);

        TopPanel players = new TopPanel();
        players.addPlayer(new PlayerButton("pallvi"));
        players.addPlayer(new PlayerButton("SHABRIN"));
        players.addPlayer(new PlayerButton("SUMIT"));
        players.addPlayer(new PlayerButton("KAVITA"));
        players.addPlayer(new PlayerButton("pallvi"));
        players.addPlayer(new PlayerButton("pallvi"));
        players.addPlayer(new PlayerButton("pallvi"));
        players.addPlayer(new PlayerButton("pallvi"));
        players.addPlayer(new PlayerButton("pallvi"));
        players.addPlayer(new PlayerButton("pallvi"));
        players.addPlayer(new PlayerButton("KAVITA"));
        players.addPlayer(new PlayerButton("KAJAL"));
        players.addPlayer(new PlayerButton("KAVITA"));
        players.setBackground(Color.BLACK);

        JScrollPane playerPane = new JScrollPane(players);
        playerPane.setPreferredSize(new Dimension(500, 230));
        JPanel contentPane = (JPanel)this.getContentPane();
        contentPane.add(playerPane, BorderLayout.NORTH);

        Deck deck = new Deck();
        add(deck, BorderLayout.CENTER);

        BottomPanel cards = new BottomPanel(500, 230);
        cards.add(new CardButton(Color.RED, Sign.ONE));
        cards.add(new CardButton(Color.GREEN, Sign.EIGHT));
        cards.add(new CardButton(Color.BLUE, Sign.FIVE));
        cards.add(new CardButton(Color.YELLOW, Sign.NINE));
        cards.add(new CardButton(Color.BLUE, Sign.FIVE));
        cards.add(new CardButton(Color.YELLOW, Sign.NINE));
        cards.add(new CardButton(Color.RED, Sign.ONE));
        cards.add(new CardButton(Color.GREEN, Sign.EIGHT));
        cards.add(new CardButton(Color.BLUE, Sign.FIVE));
        cards.add(new CardButton(Color.YELLOW, Sign.NINE));
        cards.add(new CardButton(Color.RED, Sign.ONE));
        cards.add(new CardButton(Color.GREEN, Sign.EIGHT));
        cards.add(new CardButton(Color.BLUE, Sign.FIVE));

        JScrollPane cardPane = new JScrollPane(cards);
        cardPane.setPreferredSize(new Dimension(300, 240));
        contentPane.add(cardPane, BorderLayout.SOUTH);

        LogPanel log = new LogPanel();
        log.setPreferredSize(new Dimension(300, 800));
        add(log, BorderLayout.EAST);

    }

}
