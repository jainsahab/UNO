package com.step.uno.view;

import com.step.uno.model.Card;

import java.awt.event.ActionEvent;

public interface UnoViewListener {
    void onJoin(String name, String serverAddress);
    void cardPlayed(Card card);
    void drawCard();

    void onAction(ActionEvent e);
}
