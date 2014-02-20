package com.step.uno.view;


import javax.swing.*;
import java.awt.*;

public class PlayerButton extends JButton {
    String name;
    int cardsInHand;

    public PlayerButton(String name,int cardsInHand) {
        this.name = name;
        this.cardsInHand = cardsInHand;
        this.setText(name + ":" + cardsInHand);
        this.setPreferredSize(new Dimension(150, 200));
        this.setVisible(true);
        this.setFont(new Font("Tahoma", Font.ITALIC, 20));
    }
}
