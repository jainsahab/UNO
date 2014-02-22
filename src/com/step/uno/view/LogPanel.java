package com.step.uno.view;

import javax.swing.*;
import java.awt.*;

public class LogPanel extends JPanel {

    private JScrollPane pane;
    private DefaultListModel<String> stringDefaultListModel;
    private JList<String> jList;

    public LogPanel(Dimension dimension) {
        stringDefaultListModel = new DefaultListModel<>();
        jList = new JList<>(stringDefaultListModel);
        pane = new JScrollPane(jList);
        add(pane);
        setBackground(Color.BLACK);
        setVisible(true);
        pane.setPreferredSize(dimension);
        jList.setPreferredSize(new Dimension(dimension.width - 50, dimension.height));
    }


    public void add(String log) {
        stringDefaultListModel.add(0, log);
        jList.setFont(new Font("Cambria", Font.PLAIN, 20));
    }
}
