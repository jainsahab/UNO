package com.tw.uno.master;

import com.tw.uno.Randomizer;
import com.tw.uno.view.CardButton;

import java.util.List;

public class Pack {
    private List<CardButton> cardButtons;

    public Pack(List<CardButton> cardButtons) {
        this.cardButtons = cardButtons;
    }

    public void shuffle(){
        Randomizer randomizer = new Randomizer(this.cardButtons);
        this.cardButtons = randomizer.shuffleCards();
    }

    public List<CardButton> getCardButtons(){
        shuffle();
        return this.cardButtons;
    }
}
