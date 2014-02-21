package com.step.uno.messages;

import com.step.uno.model.Card;
import com.step.uno.model.Colour;

import java.io.Serializable;

public class PlayCardAction implements Serializable {
    public Card card;
    public Colour newColour;

    public PlayCardAction(Card card) {
        this.card = card;
    }
}
