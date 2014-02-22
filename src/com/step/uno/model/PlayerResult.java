package com.step.uno.model;

import java.io.Serializable;

public class PlayerResult implements Serializable {
    Card[] cards;
    public final int points;

    public PlayerResult(Card[] cards, int points) {
        this.cards = cards;
        this.points = points;
    }
}
