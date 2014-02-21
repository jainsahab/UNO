package com.step.uno.view;

import com.step.communication.factory.CommunicationFactory;
import com.step.uno.client.GameClient;
import com.step.uno.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {
    private JTextField gameMasterField;
    private JTextField nameField;
    private UnoViewListener listener;

    public LoginForm(UnoViewListener listener) {
        this.listener = listener;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel loginPanel = new JPanel();
        loginPanel.setSize(300,300);
        this.add(loginPanel);

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
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        listener.onJoin(nameField.getText(), gameMasterField.getText());
    }
}
