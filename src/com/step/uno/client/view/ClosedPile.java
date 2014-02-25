package com.step.uno.client.view;

import javax.swing.*;
import java.awt.*;

public class ClosedPile extends JButton {
    public ClosedPile() {
        this.setPreferredSize(new Dimension(150, 200));
        String text = "Draw";
        this.setText(text);
        this.setFont(new Font("Algerian", Font.ITALIC, 25));
        this.setBackground(Color.decode("#8CA5D4"));
        setVisible(true);
    }
}
