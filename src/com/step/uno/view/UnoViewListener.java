package com.step.uno.view;

import com.step.uno.model.Card;

import java.awt.*;

public interface UnoViewListener {
    void onJoin(String name, String serverAddress);
    void cardPlayed(Card card);
    void drawCard();
    void setNewColor(Color background);
}
