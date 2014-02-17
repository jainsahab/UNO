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
        players.addPlayer(new PlayerButton("pallvi"));
        players.addPlayer(new PlayerButton("SHABRIN"));
        players.addPlayer(new PlayerButton("SUMIT"));
        players.addPlayer(new PlayerButton("PRATEEK"));
        players.addPlayer(new PlayerButton("DIGVIJAY"));
        players.addPlayer(new PlayerButton("pallvi"));
        players.addPlayer(new PlayerButton("KAVITA"));
        players.addPlayer(new PlayerButton("KAJAL"));
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
