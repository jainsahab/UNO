package com.step.uno.view;

import com.step.uno.messages.GameResult;

import javax.swing.*;

public class GameOverScreen extends JFrame {
    JPanel panel = new JPanel();
    JTable table;

    public GameOverScreen(GameResult result) {
        setTitle("Game Over");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        table = new JTable(result.playerResults.length, 2);
        panel.add(table);
        add(panel);
    }
}