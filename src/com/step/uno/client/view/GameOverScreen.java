package com.step.uno.client.view;

import com.step.uno.messages.GameResult;
import com.step.uno.model.PlayerResult;

import javax.swing.*;

public class GameOverScreen extends JFrame {

    private JTable table;
    private Object[] columns = {"Name", "Cards Left", "Points"};
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
        table = new JTable(data, columns);
        panel.add(table);
        setVisible(true);
    }
}
