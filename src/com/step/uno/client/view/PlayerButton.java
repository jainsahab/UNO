package com.step.uno.client.view;


import javax.swing.*;
import java.awt.*;

public class PlayerButton extends JButton {
    public PlayerButton(String text) {
        this.setText(text);
        this.setPreferredSize(new Dimension(175, 175));
        this.setVisible(true);
        this.setFont(new Font("Tahoma", Font.BOLD, 20));
    }
}
