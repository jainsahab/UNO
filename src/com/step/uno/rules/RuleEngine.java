package com.step.uno.rules;

import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.model.Sign;

public class RuleEngine {
    public boolean isPlayableCard(Snapshot snapshot,Card card) {
        Card openCard = snapshot.openCard;
        if(card.sign.equals(Sign.Wild)) return true;
        if(card.sign.equals(Sign.Draw4))
            return handleDraw4(snapshot,card);
        if(snapshot.draw2Run > 0)
            return card.sign.equals(openCard.sign);
        return card.sign.equals(openCard.sign) || card.colour.equals(snapshot.runningColour);
    }

    private boolean handleDraw4(Snapshot snapshot, Card card) {
        Colour runningColor = snapshot.runningColour;
        for (Card myCard : snapshot.myCards) {
            if(myCard.colour.equals(runningColor))
                return false;
        }
        return true;
    }
}
