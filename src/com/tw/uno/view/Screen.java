package com.tw.uno.view;


import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    public Screen() {
        setSize(1000, 1000);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
    }
}
