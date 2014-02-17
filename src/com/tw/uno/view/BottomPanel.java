package com.tw.uno.view;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class BottomPanel extends JPanel {
    public BottomPanel(int width, int height) {
        setSize(width, height);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    public void addButton(JButton button) {
        add(button);
    }
}
