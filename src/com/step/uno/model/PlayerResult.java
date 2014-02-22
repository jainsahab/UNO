package com.step.uno.model;

import java.io.Serializable;

public class PlayerResult implements Serializable {

    public Card[] cards;
    public final int points;
    public String name;

    public PlayerResult(Card[] cards, int points, String name) {
        this.cards = cards;
        this.points = points;
        this.name = name;
    }
}
