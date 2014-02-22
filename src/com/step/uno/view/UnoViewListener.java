package com.step.uno.view;

import com.step.uno.model.Card;

public interface UnoViewListener {
    void onJoin(String name, String serverAddress);
    void cardPlayed(Card card);
}
