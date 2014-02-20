package com.step.uno.view;

import javax.swing.*;
import java.awt.*;

public class DeckView extends JPanel {
    public DeckView(Dimension size) {
        setBackground(Color.gray);
        setLayout(new GridLayout(2, 2));
        setSize(size);
        setVisible(true);
        add(new OpenedPile());
        add(new ClosedPile());
        JLabel statusHint = new JLabel("This is hint");
        add(statusHint);
    }

    public DeckView() {
        this(new Dimension(500, 500));
    }

}
