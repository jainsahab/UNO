package com.step.uno.view;

import javax.swing.*;
import java.awt.*;

public class ClosedPile extends JButton {
    public ClosedPile() {
        this.setPreferredSize(new Dimension(150, 200));
        super.setSize(100, 100);
        setBackground(Color.green);
        setVisible(true);
    }
}
