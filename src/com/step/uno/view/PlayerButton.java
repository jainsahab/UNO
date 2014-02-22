package com.step.uno.view;


import javax.swing.*;
import java.awt.*;

public class PlayerButton extends JButton {
    String name;
    int cardsInHand;

    public PlayerButton(String name, int cardsInHand, String appendString) {
        this.name = name;
        this.cardsInHand = cardsInHand;
        this.setText(name + ":" + cardsInHand + appendString);
        this.setPreferredSize(new Dimension(150, 200));
        this.setVisible(true);
        this.setFont(new Font("Tahoma", Font.ITALIC, 20));
    }
}
