package com.tw.uno.master;

import com.tw.uno.Random;
import com.tw.uno.view.CardButton;

import java.util.ArrayList;
import java.util.List;

public class Pack {
    private List<CardButton> cardButtons = new ArrayList<>();

    public Pack(List<CardButton> cardButtons) {
        this.cardButtons = cardButtons;
    }

    public void shuffle() {
        Random random = new Random(this.cardButtons);
        for (Object o : random.shuffleCards()) {
            this.cardButtons.add((CardButton) o);
        }
    }

    public List<CardButton> getCardButtons() {
        shuffle();
        return this.cardButtons;
    }
}
