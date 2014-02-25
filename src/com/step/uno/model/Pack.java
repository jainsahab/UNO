package com.step.uno.model;

import java.util.ArrayList;
import java.util.List;

public class Pack {
    public Card[] createNewPacks(int numberOfPacks) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < numberOfPacks; i++)
            cards.addAll(createPack());
        return cards.toArray(new Card[]{});
    }

    private static List<Card> createPack() {
        List<Card> cards = new ArrayList<>();
        Colour[] colours = {Colour.Blue, Colour.Green, Colour.Red, Colour.Yellow};
        for (Colour c : colours) {
            cards.add(Card.createCard(c, "_0"));
            for (int times = 0; times < 2; times++) {
                for (int i = 1; i < 10; i++) {
                    cards.add(Card.createCard(c, "_" + i));
                }
                cards.add(Card.createCard(c, "Reverse"));
                cards.add(Card.createCard(c, "Skip"));
                cards.add(Card.createCard(c, "Draw2"));
            }
        }

        for (int times = 0; times < 4; times++) {
            cards.add(Card.createCard(Colour.Black, "Wild"));
            cards.add(Card.createCard(Colour.Black, "Draw4"));
        }
        return cards;
    }
}
