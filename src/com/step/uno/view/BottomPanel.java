package com.step.uno.view;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class BottomPanel extends JPanel {
    public BottomPanel(int width, int height) {
        Button unoButton = new Button("UNO");
        unoButton.setPreferredSize(new Dimension(100, 100));
        unoButton.setBackground(Color.ORANGE);
        add(unoButton);
        setSize(width, height);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    public void addButton(JButton button) {
        add(button);
    }
}
