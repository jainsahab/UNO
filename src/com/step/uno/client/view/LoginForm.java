package com.step.uno.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {
    private JTextField gameMasterField;
    private JTextField nameField;
    public String playerName = "me";
    private UnoViewListener listener;

    public LoginForm(UnoViewListener listener) {
        this.listener = listener;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Join Game");
        JPanel loginPanel = new JPanel();
        loginPanel.setSize(300,300);
        this.add(loginPanel);

        loginPanel.setLayout(null);

        JLabel gameMasterLabel = new JLabel("Game Master:");
        gameMasterLabel.setBounds(30,80,170,25);
        gameMasterLabel.setFont(new Font("Cambria", Font.BOLD, 20));
        loginPanel.add(gameMasterLabel);

        gameMasterField = new JTextField("127.0.0.1");
        gameMasterField.setBounds(180,80,170,35);
        gameMasterField.setFont(new Font("Cambria", Font.BOLD, 25));
        loginPanel.add(gameMasterField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30,140,170,25);
        nameLabel.setFont(new Font("Cambria", Font.BOLD, 20));
        loginPanel.add(nameLabel);

        nameField = new JTextField("me");
        nameField.setBounds(180,140,170,35);
        nameField.setFont(new Font("Cambria", Font.BOLD, 25));
        loginPanel.add(nameField);

        JButton join = new JButton("JOIN");
        join.setBounds(110,200,170,35);
        join.setFont(new Font("Cambria", Font.BOLD, 20));
        loginPanel.add(join);

        join.addActionListener(this);
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.playerName =  nameField.getText();
        listener.onJoin(nameField.getText(), gameMasterField.getText());
    }
}
