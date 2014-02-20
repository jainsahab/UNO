package com.step.uno.model;

import java.util.List;

public class PlayerResult {
    public String name;
    public Card[] cards;
    public int points;

    public PlayerResult(String name, List<Card> cards, int points) {

        this.name = name;
        this.cards = cards.toArray(new Card[]{});
        this.points = points;
    }
}
