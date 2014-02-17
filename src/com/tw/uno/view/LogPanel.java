package com.tw.uno.view;

import javax.swing.*;
import java.awt.*;

public class LogPanel extends JPanel {

    private JScrollPane pane;
    private DefaultListModel<String> stringDefaultListModel;
    private JList jList;

    public LogPanel() {
        stringDefaultListModel = new DefaultListModel<>();
        jList = new JList(stringDefaultListModel);
        pane = new JScrollPane(jList);
        add(pane);
        setSize(300, 200);
        setBackground(Color.BLACK);
        setVisible(true);
    }


    public void add(String string) {
        stringDefaultListModel.addElement(string);
    }

}
