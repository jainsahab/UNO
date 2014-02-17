package com.tw.uno.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {
    private JPanel panel;
    private LoginFormListener listener;
    private JTextField gameMasterField;
    private JTextField nameField;

    public LoginForm(LoginFormListener listener) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        this.listener = listener;
        panel = new JPanel();
        panel.setVisible(true);

        JPanel loginPanel = new JPanel();
        panel.add(loginPanel);
        loginPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        JLabel gameMasterLabel = new JLabel("Game Master:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        loginPanel.add(gameMasterLabel, constraints);

        gameMasterField = new JTextField(15);
        constraints.gridx = 1;
        constraints.gridy = 0;
        loginPanel.add(gameMasterField, constraints);

        JLabel nameLabel = new JLabel("Name:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        loginPanel.add(nameLabel, constraints);

        nameField = new JTextField(15);
        constraints.gridx = 1;
        constraints.gridy = 1;
        loginPanel.add(nameField, constraints);

        JButton join = new JButton("JOIN");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        loginPanel.add(join, constraints);

        join.addActionListener(this);
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        listener.notify(gameMasterField.getText(), nameField.getText());
    }

}
