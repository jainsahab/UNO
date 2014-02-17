package com.tw.uno.master;

import com.tw.uno.view.CardButton;
import com.tw.uno.view.Sign;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameSetUpFactory {

    public static Pack getPack() {
        List<CardButton> cardButtons = new ArrayList();
        for (Sign sign : Sign.values()) {
            if (sign.equals(Sign.ZERO)) {
                cardButtons.add(new CardButton(Color.RED, sign));
                cardButtons.add(new CardButton(Color.GREEN, sign));
                cardButtons.add(new CardButton(Color.BLUE, sign));
                cardButtons.add(new CardButton(Color.YELLOW, sign));
            }
            else {
                cardButtons.add(new CardButton(Color.RED, sign));
                cardButtons.add(new CardButton(Color.RED, sign));
                cardButtons.add(new CardButton(Color.GREEN, sign));
                cardButtons.add(new CardButton(Color.GREEN, sign));
                cardButtons.add(new CardButton(Color.BLUE, sign));
                cardButtons.add(new CardButton(Color.BLUE, sign));
                cardButtons.add(new CardButton(Color.YELLOW, sign));
                cardButtons.add(new CardButton(Color.YELLOW, sign));

            }
        }
        return new Pack(cardButtons);
    }
}
