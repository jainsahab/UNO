package com.step.uno.client.view;

import com.step.uno.messages.GameResult;
import com.step.uno.model.PlayerResult;

import javax.swing.*;
import java.awt.*;

public class GameOverScreen extends JFrame {
    private JTable table;
    private final JPanel panel;

    public GameOverScreen() {
        setTitle("Game Over");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 500);
        setResizable(false);
        panel = new JPanel();
        add(panel);
    }

    public void showResult(GameResult result) {
        String[][] data = new String[result.playerResults.length][3];
        int index = 0;
        for (PlayerResult playerResult : result.playerResults) {
            int totalCards = playerResult.cards.length;
            String pointsToString = Integer.toString(playerResult.points);
            String[] row = {playerResult.name, Integer.toString(totalCards), pointsToString};
            data[index] = row;
            index++;
        }
        String[] headers = {"Name", "Cards Left", "Points"};
        table = new JTable(data, headers);
        table.setEnabled(false);
        table.setPreferredSize(new Dimension(400, 400));
        table.setFont(new Font("ARIAL", Font.PLAIN, 30));
        table.setBackground(new Color(133, 133, 136));
        table.setRowHeight(40);
        panel.add(table);
        setVisible(true);
    }
}