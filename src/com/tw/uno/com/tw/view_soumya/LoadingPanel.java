package com.tw.uno.com.tw.view_soumya;

import java.awt.*;
import javax.swing.JPanel;

public class LoadingPanel extends JPanel {
    LoadingPanel()
    {
        setBackground(Color.BLACK);
        setFocusable(true);

    }

    private int xCoordinate =100;
    private int  yCoordinate = 150;

    public void paint(Graphics G){
        super.paint(G);

        G.setColor(Color.RED);
        G.setFont(new Font(Font.SANS_SERIF ,Font.BOLD,20));
        G.drawString("Loading the Game.",xCoordinate , yCoordinate);

        G.drawString("Please wait...", xCoordinate, yCoordinate+20);
    }
}