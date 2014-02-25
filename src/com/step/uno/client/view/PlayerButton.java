package com.step.uno.client.view;


import com.step.uno.client.ClientPlayer;

import javax.swing.*;
import java.awt.*;

public class PlayerButton extends JButton {
    public final String text;
    public ClientPlayer player;

    public PlayerButton(String text, ClientPlayer player) {
        this.text = text;
        this.player = player;
        this.setText(text);

        this.setPreferredSize(new Dimension(175, 175));
        this.setVisible(true);
        this.setFont(new Font("Tahoma", Font.BOLD, 20));
    }

    public ClientPlayer getPlayer() {
        return this.player;
    }
}
