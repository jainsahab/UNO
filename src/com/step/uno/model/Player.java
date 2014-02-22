package com.step.uno.model;

import com.step.uno.messages.Snapshot;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    private List<Card> cards = new ArrayList<>();
    private boolean declaredUno;

    public Player(String name) {
        this.name = name;
    }

    public void take(Card card) {
        cards.add(card);
        declaredUno = false;
    }

    public void populateSelf(Snapshot snapshot) {
        snapshot.myCards = cards.toArray(new Card[]{});
    }

    public PlayerSummary generateSummary() {
        return new PlayerSummary(name, cards.size(), declaredUno);
    }

    public void play(Card playedCard) {
        for (Card card : cards) {
            if (card.colour.equals(playedCard.colour) && card.sign.equals(playedCard.sign)) {
                cards.remove(card);
                break;
            }
        }
    }

    public boolean hasWon() {
        return cards.size() == 0;
    }

    public PlayerResult generateResult() {
        PlayerResult result = new PlayerResult(cards.toArray(new Card[]{}), calculatePoints());
        return result;
    }

    private int calculatePoints() {
        int total = 0;
        for (Card card : cards) {
            total += card.sign.points;
        }
        return total;
    }
}
