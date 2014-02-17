package com.tw.uno.view;
import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {

    public TopPanel() {

//        this.setPreferredSize(new Dimension(1000, 220));
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setBackground(Color.BLUE);
    }
    public void addPlayer(PlayerButton playerButton){
        this.add(playerButton);
    }
}
