package com.step.uno.model;

import com.step.uno.messages.Snapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Card implements Serializable {
    public Colour colour;
    public Sign sign;

    public Card() {
    }

    public static Card createCard(Colour c, String signText) {
        Card card = new Card();
        card.colour = c;
        card.sign = Sign.valueOf(signText);
        return card;
    }

    public boolean isPlayableCard(Card card,int draw2Run,Colour runningColour) {
        Card openCard = this;
        if(card.sign.equals(Sign.Wild) && draw2Run==0) return true;
        if(card.sign.equals(Sign.Draw4) && draw2Run==0) return true;
        if(draw2Run > 0)
            return card.sign.equals(openCard.sign);
        return card.sign.equals(openCard.sign) || card.colour.equals(runningColour);
    }

}