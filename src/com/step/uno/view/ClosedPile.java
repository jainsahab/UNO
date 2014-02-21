package com.step.uno.view;

import javax.swing.*;
import java.awt.*;

public class ClosedPile extends JButton {
    public ClosedPile() {
        this.setPreferredSize(new Dimension(150, 200));
        this.setSize(100, 100);
        String text = "Closed Pile";
        this.setText(text);
        this.setFont(new Font("Algerian", Font.ITALIC, 30));
        setVisible(true);
    }
}
