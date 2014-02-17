package com.tw.uno.view;

import javax.swing.JFrame;

public class Loading extends JFrame {
    public Loading() {
        setTitle("UNO");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(380, 330);
        setResizable(false);
        setVisible(true);
        add(new LoadingPanel());
    }

}