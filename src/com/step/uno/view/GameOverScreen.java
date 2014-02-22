package com.step.uno.view;

import com.step.uno.messages.GameResult;

import javax.swing.*;

public class GameOverScreen extends JFrame {
    JPanel panel = new JPanel();
    JTable table;

    public GameOverScreen(GameResult result) {
        setTitle("Game Over");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(380, 330);
        setResizable(false);
        setVisible(true);
        add(panel);
        table = new JTable(result.playerResults.length, 2);
        panel.add(table);
    }
}
