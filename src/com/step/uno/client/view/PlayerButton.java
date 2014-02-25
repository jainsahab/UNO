package com.step.uno.client.view;


import com.step.uno.client.ClientPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class PlayerButton extends JButton {
    public final String label;
    public final ClientPlayer player;

    public PlayerButton(String label, ClientPlayer player) {
        super(label);
        this.label = label;
        this.player = player;
        Dimension size = getPreferredSize();

        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setFont(new Font("Arial", Font.BOLD, 23));
        setContentAreaFilled(false);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }

    Shape shape;

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }

    public ClientPlayer getPlayer() {
        return this.player;
    }

}