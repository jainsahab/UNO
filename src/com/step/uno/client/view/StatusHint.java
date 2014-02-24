package com.step.uno.client.view;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class StatusHint extends JTextArea {
    public StatusHint() {
        super("This is Hint");
        setEditable(false);
        setBackground(Color.lightGray);
        setBorder(new CompoundBorder());
    }
}
