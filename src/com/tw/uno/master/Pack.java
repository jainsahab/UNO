package com.tw.uno.master;

import com.tw.uno.Random;
import com.tw.uno.view.CardButton;

import java.util.List;

public class Pack {
    private List<CardButton> cardButtons;

    public Pack(List<CardButton> cardButtons) {
        this.cardButtons = cardButtons;
    }

    public void shuffle(){
        Random randomizer = new Random(this.cardButtons);
        this.cardButtons = randomizer.shuffleCards();
    }

    public List<CardButton> getCardButtons(){
        shuffle();
        return this.cardButtons;
    }
}
