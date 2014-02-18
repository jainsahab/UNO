package com.tw.uno.view;

import javax.swing.JFrame;

public class LoadingForm extends JFrame {
    public LoadingForm() {
        setTitle("UNO");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(380, 330);
        setResizable(false);
        add(new LoadingPanel());
    }

}