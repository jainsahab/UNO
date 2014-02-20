package com.tw.uno.view;


import com.tw.uno.master.ServerPlayer;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    private final Dimension screenSize;
    private TopPanel playerButtons;
    private DeckView deck;
    private BottomPanel cards;
    private LogPanel log;

    public Screen() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("UNO");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(screenSize);

        playerButtons = new TopPanel();
//        playerButtons.addPlayerButton(new PlayerButton("pallvi"));
//        playerButtons.addPlayerButton(new PlayerButton("SHABRIN"));
//        playerButtons.addPlayerButton(new PlayerButton("SUMIT"));
//        playerButtons.addPlayerButton(new PlayerButton("KAVITA"));
//        playerButtons.addPlayerButton(new PlayerButton("pallvi"));
//        playerButtons.addPlayerButton(new PlayerButton("pallvi"));
//        playerButtons.addPlayerButton(new PlayerButton("pallvi"));
//        playerButtons.addPlayerButton(new PlayerButton("pallvi"));
//        playerButtons.addPlayerButton(new PlayerButton("pallvi"));
//        playerButtons.addPlayerButton(new PlayerButton("pallvi"));
//        playerButtons.addPlayerButton(new PlayerButton("KAVITA"));
//        playerButtons.addPlayerButton(new PlayerButton("KAJAL"));
//        playerButtons.addPlayerButton(new PlayerButton("KAVITA"));
        playerButtons.setBackground(Color.BLACK);

        JScrollPane playerPane = new JScrollPane(playerButtons);
        playerPane.setPreferredSize(new Dimension(500, 230));
        JPanel contentPane = (JPanel)this.getContentPane();
        contentPane.add(playerPane, BorderLayout.NORTH);

        deck = new DeckView();
        add(deck, BorderLayout.CENTER);

        cards = new BottomPanel(500, 230);
//        cards.add(new CardButton(Color.RED, Sign.ONE));
//        cards.add(new CardButton(Color.GREEN, Sign.EIGHT));
//        cards.add(new CardButton(Color.BLUE, Sign.FIVE));
//        cards.add(new CardButton(Color.YELLOW, Sign.NINE));
//        cards.add(new CardButton(Color.BLUE, Sign.FIVE));
//        cards.add(new CardButton(Color.YELLOW, Sign.NINE));
//        cards.add(new CardButton(Color.RED, Sign.ONE));
//        cards.add(new CardButton(Color.GREEN, Sign.EIGHT));
//        cards.add(new CardButton(Color.BLUE, Sign.FIVE));
//        cards.add(new CardButton(Color.YELLOW, Sign.NINE));
//        cards.add(new CardButton(Color.RED, Sign.ONE));
//        cards.add(new CardButton(Color.GREEN, Sign.EIGHT));
//        cards.add(new CardButton(Color.BLUE, Sign.FIVE));

        JScrollPane cardPane = new JScrollPane(cards);
        cardPane.setPreferredSize(new Dimension(300, 240));
        contentPane.add(cardPane, BorderLayout.SOUTH);

        log = new LogPanel();
        log.setPreferredSize(new Dimension(300, 800));
        add(log, BorderLayout.EAST);
    }

    public void addPlayer(ServerPlayer serverPlayer){
        playerButtons.addPlayerButton(new PlayerButton(serverPlayer.getName()));
    }
}