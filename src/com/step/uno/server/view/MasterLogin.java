package com.step.uno.server.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MasterLogin extends JFrame implements ActionListener {
    private JTextField numberOfPacks;
    private JTextField numberOfPlayers;
    private ServerUnoViewListener listener;

    public MasterLogin(ServerUnoViewListener listener) {
        this.listener = listener;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Start Game Master");
        JPanel loginPanel = new JPanel();
        loginPanel.setSize(300,300);
        this.add(loginPanel);

        loginPanel.setLayout(null);

        JLabel numberOfPlayersLabel = new JLabel("Number of players:");
        numberOfPlayersLabel.setBounds(30, 80, 190, 25);
        numberOfPlayersLabel.setFont(new Font("Cambria", Font.BOLD, 20));
        loginPanel.add(numberOfPlayersLabel);

        numberOfPacks = new JTextField("1");
        numberOfPacks.setBounds(210, 140, 170, 35);
        numberOfPacks.setFont(new Font("Cambria", Font.BOLD, 25));
        loginPanel.add(numberOfPacks);

        JLabel numberOfPacksLabel = new JLabel("Number of Packs:");
        numberOfPacksLabel.setBounds(30, 140, 170, 25);
        numberOfPacksLabel.setFont(new Font("Cambria", Font.BOLD, 20));
        loginPanel.add(numberOfPacksLabel);

        numberOfPlayers = new JTextField();
        numberOfPlayers.setBounds(210, 80, 170, 35);
        numberOfPlayers.setFont(new Font("Cambria", Font.BOLD, 25));
        loginPanel.add(numberOfPlayers);

        JButton start = new JButton("Start ");
        start.setBounds(110, 200, 170, 35);
        start.setFont(new Font("Cambria", Font.BOLD, 20));
        loginPanel.add(start);

        start.addActionListener(this);
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        listener.onJoin(Integer.parseInt(numberOfPlayers.getText()), Integer.parseInt(numberOfPacks.getText()));
        this.setVisible(false);
    }
}
