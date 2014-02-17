package com.tw.uno.view;

import javax.swing.*;
import java.awt.*;

public class Start {
    JFrame frame;

    public Start() {
        frame = new JFrame("CREATE GAME");
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel startingPanel = new JPanel();
        frame.add(startingPanel);
        startingPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel noOfPlayers = new JLabel("No of Players ");
        noOfPlayers.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        constraints.gridx = 0;
        constraints.gridy = 0;
        startingPanel.add(noOfPlayers, constraints);

        JTextField noOfPlayersField = new JTextField(15);
        constraints.gridx = 1;
        constraints.gridy = 0;
        startingPanel.add(noOfPlayersField, constraints);

        JLabel noOfPacks = new JLabel("No of Packs ");
        noOfPacks.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        constraints.gridx = 0;
        constraints.gridy = 1;
        startingPanel.add(noOfPacks, constraints);

        JTextField noOfPacksField = new JTextField(15);
        constraints.gridx = 1;
        constraints.gridy = 1;
        startingPanel.add(noOfPacksField, constraints);

        JButton join = new JButton("START GAME");
        join.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        join.setBackground(Color.cyan);
        startingPanel.add(join, constraints);
    }
}
