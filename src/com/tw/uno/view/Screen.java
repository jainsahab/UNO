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
        playersPanel.setBackground(Color.blue);
        add(playersPanel, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.gridheight = 2;
        JPanel center = new JPanel();
        center.setBackground(Color.red);
        add(center, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 3;
        c.gridheight = 1;
        JPanel cards = new JPanel();
        cards.setBackground(Color.black);
        add(cards, c);

        c.gridx = 3;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 4;
        JPanel log = new JPanel();
        log.setBackground(Color.gray);
        add(log, c);

    }
}
