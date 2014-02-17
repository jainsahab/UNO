package com.tw.uno.view;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;


public class GameOver extends JFrame {
    public GameOver() {
        setTitle("Game Over");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(380, 330);
        setResizable(false);
        setVisible(true);
        add(new GameOverPanel());
    }
}
