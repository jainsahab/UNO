package com.tw.uno.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
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
        AbstractButton abstract1 = new JToggleButton("SET");
        panel.add(abstract1);
        group.add(abstract1);
        AbstractButton abstract2 = new JRadioButton("BLUE");
        panel.add(abstract2);
        group.add(abstract2);
        AbstractButton abstract3 = new JCheckBox("GREEN");
        panel.add(abstract3);
        group.add(abstract3);
        AbstractButton abstract4 = new JRadioButtonMenuItem("YELLOW");
        panel.add(abstract4);
        group.add(abstract4);
        AbstractButton abstract5 = new JCheckBoxMenuItem("RED");
        panel.add(abstract5);
        group.add(abstract5);
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}