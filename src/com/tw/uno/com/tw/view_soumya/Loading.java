package com.tw.uno.com.tw.view_soumya;

import javax.swing.JFrame;

public class Loading extends JFrame {
    Loading() {
        setTitle("UNO");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(380, 330);
        setResizable(false);
        setVisible(true);
        add(new LoadingPanel());
    }
}