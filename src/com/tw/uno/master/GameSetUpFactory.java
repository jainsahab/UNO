package com.tw.uno.master;

import com.tw.uno.view.Card;
import com.tw.uno.view.Sign;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameSetUpFactory {

    public static Pack getPack() {
        List<Card> cards = new ArrayList();
        for (Sign sign : Sign.values()) {
            if (sign.equals(Sign.ZERO)) {
                cards.add(new Card(Color.RED, sign));
                cards.add(new Card(Color.GREEN, sign));
                cards.add(new Card(Color.BLUE, sign));
                cards.add(new Card(Color.YELLOW, sign));
            }
            else {
                cards.add(new Card(Color.RED, sign));
                cards.add(new Card(Color.RED, sign));
                cards.add(new Card(Color.GREEN, sign));
                cards.add(new Card(Color.GREEN, sign));
                cards.add(new Card(Color.BLUE, sign));
                cards.add(new Card(Color.BLUE, sign));
                cards.add(new Card(Color.YELLOW, sign));
                cards.add(new Card(Color.YELLOW, sign));

            }
        }
        return new Pack(cards);
    }
}
