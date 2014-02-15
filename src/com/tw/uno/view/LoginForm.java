package com.tw.uno.view;

import javax.swing.*;
import java.awt.*;

public class LoginForm {
    JFrame frame;

    public LoginForm() {
        frame = new JFrame("UNO");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel loginPanel = new JPanel();
        frame.add(loginPanel);
        loginPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10,10,10,10);

        JLabel gameMasterLabel = new JLabel("Game Master:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        loginPanel.add(gameMasterLabel,constraints);

        JTextField gameMasterField = new JTextField(15);
        constraints.gridx = 1;
        constraints.gridy = 0;
        loginPanel.add(gameMasterField,constraints);

        JLabel nameLabel = new JLabel("Name:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        loginPanel.add(nameLabel,constraints);

        JTextField nameField = new JTextField(15);
        constraints.gridx = 1;
        constraints.gridy = 1;
        loginPanel.add(nameField,constraints);

        JButton join = new JButton("JOIN");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        loginPanel.add(join,constraints);
    }
}
