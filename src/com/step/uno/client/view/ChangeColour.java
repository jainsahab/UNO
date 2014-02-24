package com.step.uno.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeColour implements ActionListener {
    private UnoViewListener listener;
    private JButton redButton;
    private JButton greenButton;
    private JButton yellowButton;
    private JButton blueButton;
    private JDialog dialog;

    public ChangeColour(PlayerScreen playerScreen, Dialog.ModalityType documentModal, UnoViewListener listener) {
        this.listener = listener;
        dialog = new JDialog(playerScreen, documentModal);
        dialog.setLayout(new GridLayout(2, 2));

        redButton = new JButton();
        redButton.setBackground(Color.RED);
        redButton.addActionListener(this);
        dialog.add(redButton);

        greenButton = new JButton();
        greenButton.setBackground(Color.GREEN);
        greenButton.addActionListener(this);
        dialog.add(greenButton);

        yellowButton = new JButton();
        yellowButton.setBackground(Color.YELLOW);
        yellowButton.addActionListener(this);
        dialog.add(yellowButton);

        blueButton = new JButton();
        blueButton.setBackground(Color.BLUE);
        blueButton.addActionListener(this);
        dialog.add(blueButton);

        dialog.setSize(200, 200);
    }

    public void makeVisible() {
        dialog.setVisible(true);
    }

    public void makeInvisible() {
        dialog.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = ((JButton) e.getSource());
        listener.setNewColor(source.getBackground());
    }
}