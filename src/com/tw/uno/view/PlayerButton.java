package com.tw.uno.view;


import javax.swing.*;
import java.awt.*;

public class PlayerButton extends JButton {
    String name;

    public PlayerButton(String name) {
        this.name = name;
        this.setText(name);
        this.setPreferredSize(new Dimension(150, 200));
        this.setVisible(true);
        this.setFont(new Font("Tahoma", Font.ITALIC, 20));
    }
}
