package com.tw.uno.view;

import javax.swing.*;
import java.awt.*;

public class Deck extends JPanel {
    public Deck(Dimension size) {
        setBackground(Color.gray);
        setLayout(new GridLayout(2, 2));
        setSize(size);
        setVisible(true);
        add(new OpenedPile());
        add(new ClosedPile());
        JLabel statusHint = new JLabel("This is hint");
        add(statusHint);
    }

    public Deck() {
        this(new Dimension(500, 500));
    }

}
