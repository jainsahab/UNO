package com.step.uno.rules;

import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.model.Sign;

public class RuleEngine {
    public boolean isPlayableCard(Snapshot snapshot,Card card) {
        Card openCard = snapshot.openCard;
        if(card.sign.equals(Sign.Wild) && snapshot.draw2Run==0) return true;
        if(card.sign.equals(Sign.Draw4) && snapshot.draw2Run==0) return true;
        if(snapshot.draw2Run > 0)
            return card.sign.equals(openCard.sign);
        return card.sign.equals(openCard.sign) || card.colour.equals(snapshot.runningColour);
    }
}
