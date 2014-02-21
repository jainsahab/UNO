package com.step.uno.server;

import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.model.Player;

public interface PlayerProxyObserver {
    void onPlayerRegistered(Player player);

    void onPlayerPlayed(Player player, Card card, Colour newColour);

    void onPlayerDrewCard(Player player);
}
