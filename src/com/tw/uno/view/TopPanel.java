package com.tw.uno.view;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {
    private JScrollPane pane;
    private DefaultListModel<Player> playerDefaultListModel;
    private JList jList;

    public TopPanel() {
        playerDefaultListModel = new DefaultListModel<>();
        jList = new JList(playerDefaultListModel);
        pane = new JScrollPane(jList);
        add(pane);
        setSize(300, 200);
        setBackground(Color.BLACK);
        setVisible(true);
    }

    public void addPlayer(Player player) {
        playerDefaultListModel.addElement(player);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000,1000);
        frame.setVisible(true);
        TopPanel players = new TopPanel();
        players.addPlayer(new Player("sumit"));
        players.setVisible(true);
        frame.add(players);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}