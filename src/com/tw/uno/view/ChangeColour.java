package com.tw.uno.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

public class ChangeColour {
    public ChangeColour() {
        JFrame frame = new JFrame("Colour Changer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(0, 1));
        Border border = BorderFactory.createTitledBorder("Pick Colour");
        panel.setBorder(border);
        ButtonGroup group = new ButtonGroup();
        AbstractButton abstract2 = new JCheckBox("BLUE");
        panel.add(abstract2);
        group.add(abstract2);
        AbstractButton abstract3 = new JCheckBox("GREEN");
        panel.add(abstract3);
        group.add(abstract3);
        AbstractButton abstract4 = new JCheckBox("YELLOW");
        panel.add(abstract4);
        group.add(abstract4);
        AbstractButton abstract5 = new JCheckBox("RED");
        panel.add(abstract5);
        group.add(abstract5);
        AbstractButton abstractButton = new JToggleButton("SET COLOUR");
        panel.add(abstractButton);
        group.add(abstractButton);
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}