package com.step.uno.client.view;

import com.step.uno.model.Card;
import java.awt.*;
import java.awt.event.ActionEvent;

public interface UnoViewListener {
    void onJoin(String name, String serverAddress);
    void cardPlayed(Card card);
    void drawCard();
    void setNewColor(Color background);
    void onAction(ActionEvent e);
}
