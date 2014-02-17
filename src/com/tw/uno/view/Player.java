package com.tw.uno.view;


import javax.swing.*;
import java.awt.*;

public class Player extends JButton {
    String name;

    public Player(String name) {
        this.name = name;
        this.setText(name);
        this.setPreferredSize(new Dimension(150, 200));
        this.setVisible(true);
    }
}
