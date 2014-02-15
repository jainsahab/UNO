package com.tw.uno.view;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {

    private final Dimension screenSize;

    public Screen() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("UNO");
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(screenSize);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.gridheight = 1;
        Players playersPanel = new Players();
        add(playersPanel, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.gridheight = 2;
        Deck deck = new Deck();
        add(deck, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 3;
        c.gridheight = 1;
        BottomPanel cards = new BottomPanel();
        add(cards, c);

        c.gridx = 3;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 4;
        LogPanel log = new LogPanel();
        add(log, c);

    }
}
