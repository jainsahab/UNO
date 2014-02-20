package com.step.uno.view;

import javax.swing.*;
import java.awt.*;

public class LogPanel extends JPanel {

    private JScrollPane pane;
    private DefaultListModel<String> stringDefaultListModel;
    private JList<String> jList;

    public LogPanel() {
        stringDefaultListModel = new DefaultListModel<>();
        jList = new JList<>(stringDefaultListModel);
        pane = new JScrollPane(jList);
        add(pane);
        setBackground(Color.BLACK);
        setVisible(true);
    }


    public void add(String string) {
        stringDefaultListModel.addElement(string);
    }

}
