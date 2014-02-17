package com.tw.uno.view;


import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Screen extends JFrame {

    private final Dimension screenSize;

    public Screen() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("UNO");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(screenSize);

        TopPanel players = new TopPanel();
        players.addPlayer(new Player("pallvi"));
        players.addPlayer(new Player("SHABRIN"));
        players.addPlayer(new Player("SUMIT"));
        players.addPlayer(new Player("PRATEEK"));
        players.addPlayer(new Player("DIGVIJAY"));
        players.addPlayer(new Player("pallvi"));
        players.addPlayer(new Player("KAVITA"));
        players.addPlayer(new Player("KAJAL"));
        players.setBackground(Color.BLACK);
        add(players, BorderLayout.NORTH);

        Deck deck = new Deck();
        add(deck, BorderLayout.CENTER);

        BottomPanel bottomPanel = new BottomPanel(400, 400);
        bottomPanel.add(new Card(Color.RED, Sign.ONE));
        bottomPanel.add(new Card(Color.GREEN, Sign.EIGHT));
        bottomPanel.add(new Card(Color.BLUE, Sign.FIVE));
        bottomPanel.add(new Card(Color.RED, Sign.SEVEN));
        bottomPanel.add(new Card(Color.YELLOW, Sign.NINE));

        add(bottomPanel, BorderLayout.SOUTH);

        LogPanel log = new LogPanel();
        log.setPreferredSize(new Dimension(300, 800));
        add(log, BorderLayout.EAST);
    }

}
