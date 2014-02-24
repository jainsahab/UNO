package com.step.uno.view;

import javax.swing.*;
import java.awt.*;

public class UnoButton extends JButton {
    public UnoButton() {
        setPreferredSize(new Dimension(100, 100));
        setBackground(Color.decode("#FA880F"));
        setFont(new Font("Arial", Font.BOLD, 75));
        setText(" Declare UNO");
    }
}
