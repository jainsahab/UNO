package com.step.uno.model;

import java.util.ArrayList;
import java.util.List;

public class Card {
    public Colour colour;
    public Sign sign;

    //in one pack
    // 4 X {wildcard,wild+4}, 2 X {1-9, +2, reverse, skip}, 0,  for colours {red, green, blue, yellow},

    public static Card[] createNewPacks(int packs) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < packs; i++)
            cards.addAll(createPack());
        return cards.toArray(new Card[]{});
    }

    private static List<Card> createPack() {
        List<Card> cards = new ArrayList<>();
        Colour[] colours = {Colour.Blue,Colour.Green,Colour.Red,Colour.Yellow};
        for (Colour c : colours) {
            cards.add(createCard(c, "_0"));
            for(int times = 0;times<2;times++){
                for (int i = 1; i < 10; i++) {
                    cards.add(createCard(c, "_" + i));
                }
                cards.add(createCard(c, "Reverse"));
                cards.add(createCard(c, "Skip"));
                cards.add(createCard(c, "DrawTwo"));
            }
        }

        for(int times = 0;times<4;times++){
            cards.add(createCard(Colour.Black, "Wild"));
            cards.add(createCard(Colour.Black, "WildDrawFour"));
        }
        return cards;
    }

    private static Card createCard(Colour c, String signText) {
        Card card = new Card();
        card.colour = c;
        card.sign = Sign.valueOf(signText);
        return card;
    }
}


