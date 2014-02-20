package com.step.uno.messages;

import com.step.uno.model.Card;

public class WaitingForDrawnCardAction {
    public Card card;

    public WaitingForDrawnCardAction(Card card) {
        this.card = card;
    }
}
