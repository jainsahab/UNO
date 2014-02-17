package com.tw.uno.master;

import com.tw.uno.Randomizer;
import com.tw.uno.view.Card;

import java.util.List;

public class Pack {
    private List<Card> cards;

    public Pack(List<Card> cards) {
        this.cards = cards;
    }

    public void shuffle(){
        Randomizer randomizer = new Randomizer(this.cards);
        this.cards = randomizer.shuffleCards();
    }

    public List<Card> getCards(){
        shuffle();
        return this.cards;
    }
}
