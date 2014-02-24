package com.step.uno.client.view;

import javax.swing.JFrame;

public class LoadingForm extends JFrame {
    public LoadingForm() {
        this.setTitle("UNO");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(380, 330);
        this.setResizable(false);
        this.add(new LoadingPanel());
        this.setLocationRelativeTo(null);
    }
}