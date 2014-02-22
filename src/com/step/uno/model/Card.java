package com.step.uno.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Card implements Serializable {
    public Colour colour;
    public Sign sign;

    public Card() {
    }

    public static Card[] createNewPacks(int packs) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < packs; i++)
            cards.addAll(createPack());
        return cards.toArray(new Card[]{});
    }

    private static List<Card> createPack() {
        List<Card> cards = new ArrayList<>();
        Colour[] colours = {Colour.Blue, Colour.Green, Colour.Red, Colour.Yellow};
        for (Colour c : colours) {
            cards.add(createCard(c, "_0"));
            for (int times = 0; times < 2; times++) {
                for (int i = 1; i < 10; i++) {
                    cards.add(createCard(c, "_" + i));
                }
                cards.add(createCard(c, "Reverse"));
                cards.add(createCard(c, "Skip"));
                cards.add(createCard(c, "Draw2"));
            }
        }

        for (int times = 0; times < 4; times++) {
            cards.add(createCard(Colour.Black, "Wild"));
            cards.add(createCard(Colour.Black, "Draw4"));
        }
        return cards;
    }

    public static Card createCard(Colour c, String signText) {
        Card card = new Card();
        card.colour = c;
        card.sign = Sign.valueOf(signText);
        return card;
    }
}