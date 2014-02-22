package com.step.uno.rules;

import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RuleEngineTest {
    RuleEngine ruleEngine = new RuleEngine();
    @Test
    public void on_any_number_card_the_card_of_same_number_should_be_playable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Blue,"_1");
        Card card = Card.createCard(Colour.Yellow,"_1");
        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertTrue(result);
    }

    @Test
    public void on_any_number_card_the_card_of_same_colour_should_be_playable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Blue,"_1");
        snapshot.runningColour = Colour.Blue;
        Card card = Card.createCard(Colour.Blue,"Skip");
        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertTrue(result);
    }

    @Test
    public void on_any_number_card_the_sign_or_color_of_another_card_does_not_match_then_it_is_unplayable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Blue,"_1");
        snapshot.runningColour = snapshot.openCard.colour;
        Card card = Card.createCard(Colour.Green,"Reverse");
        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertFalse(result);
    }

    @Test
    public void on_any_draw_performed_draw_two_card_any_card_of_same_color_is_playable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Blue,"Draw2");
        snapshot.runningColour = snapshot.openCard.colour;
        Card card = Card.createCard(Colour.Blue,"_9");
        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertTrue(result);
    }

    @Test
    public void on_any_draw_performed_draw_two_card_any_card_of_same_sign_is_playable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Blue,"Draw2");
        Card card = Card.createCard(Colour.Green,"Draw2");
        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertTrue(result);
    }

    @Test
    public void on_any_draw_performed_draw_two_card_any_card_of_same_sign_and_same_color_is_playable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Green,"Draw2");
        snapshot.runningColour = snapshot.openCard.colour;
        Card card = Card.createCard(Colour.Green,"Draw2");
        
        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertTrue(result);
    }

    @Test
    public void on_any_draw_performed_draw_two_card_any_card_of_different_sign_and_color_is_unplayable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Green,"Draw2");
        snapshot.runningColour = snapshot.openCard.colour;
        Card card = Card.createCard(Colour.Red,"_2");
        
        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertFalse(result);
    }

    @Test
    public void on_any_draw_two_card_any_draw_two_card_is_playable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Green,"Draw2");
        snapshot.runningColour = snapshot.openCard.colour;
        snapshot.draw2Run = 1;
        Card card = Card.createCard(Colour.Red,"Draw2");
        
        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertTrue(result);
    }

    @Test
    public void on_any_draw_two_card_the_card_of_same_colour_with_sign_other_than_draw_two_card_is_unplayable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Green,"Draw2");
        snapshot.runningColour = snapshot.openCard.colour;
        snapshot.draw2Run = 1;
        Card card = Card.createCard(Colour.Green,"_2");
        
        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertFalse(result);
    }

    @Test
    public void on_any_skip_card_the_card_of_same_colour_is_playable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Green,"Skip");
        snapshot.runningColour = snapshot.openCard.colour;
        Card card = Card.createCard(Colour.Green,"_5");
        
        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertTrue(result);
    }

    @Test
    public void on_any_skip_card_the_card_of_same_sign_is_playable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Green,"Skip");
        snapshot.runningColour = snapshot.openCard.colour;
        Card card = Card.createCard(Colour.Blue,"Skip");
        
        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertTrue(result);
    }

    @Test
    public void on_any_skip_card_the_card_of_same_colour_and_same_sign_is_playable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Green,"Skip");
        snapshot.runningColour = snapshot.openCard.colour;
        Card card = Card.createCard(Colour.Green,"Skip");
        
        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertTrue(result);
    }

    @Test
    public void on_any_skip_card_the_card_of_different_colour_and_different_sign_is_unplayable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Green,"Skip");
        snapshot.runningColour = snapshot.openCard.colour;
        Card card = Card.createCard(Colour.Blue,"_2");
        
        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertFalse(result);
    }

    @Test
    public void on_any_reverse_card_the_card_of_same_colour_is_playable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Green,"Reverse");
        snapshot.runningColour = snapshot.openCard.colour;
        Card card = Card.createCard(Colour.Green,"_5");
        
        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertTrue(result);
    }

    @Test
    public void on_any_reverse_card_the_card_of_same_sign_is_playable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Green,"Reverse");
        snapshot.runningColour = snapshot.openCard.colour;
        Card card = Card.createCard(Colour.Yellow,"Reverse");
        
        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertTrue(result);
    }

    @Test
    public void on_any_reverse_card_the_card_of_same_colour_and_same_sign_is_playable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Green,"Reverse");
        snapshot.runningColour = snapshot.openCard.colour;
        Card card = Card.createCard(Colour.Green,"Reverse");

        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertTrue(result);
    }

    @Test
    public void on_any_reverse_card_the_card_of_different_colour_and_different_sign_is_unplayable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Green,"Reverse");
        snapshot.runningColour = snapshot.openCard.colour;
        Card card = Card.createCard(Colour.Blue,"_2");

        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertFalse(result);
    }

    @Test
    public void on_any_card_wild_card_is_playable() {
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Green,"Reverse");
        snapshot.runningColour = snapshot.openCard.colour;
        Card card = Card.createCard(Colour.Black,"Wild");

        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertTrue(result);
    }

    @Test
    public void if_you_have_a_card_of_running_colour_then_draw4_is_unplayable() {
        Snapshot snapshot = new Snapshot();
        snapshot.myCards = new Card[]{Card.createCard(Colour.Green, "_2")
                , Card.createCard(Colour.Blue, "_3")
                ,Card.createCard(Colour.Red,"_4")};
        snapshot.openCard = Card.createCard(Colour.Red,"_5");
        snapshot.runningColour = snapshot.openCard.colour;
        Card card = Card.createCard(Colour.Black, "Draw4");

        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertFalse(result);
    }


    @Test
    public void if_you_dont_have_a_card_of_running_colour_then_draw4_is_playable() {
        Snapshot snapshot = new Snapshot();
        snapshot.myCards = new Card[]{Card.createCard(Colour.Green, "_2")
                , Card.createCard(Colour.Blue, "_3")
                };
        snapshot.openCard = Card.createCard(Colour.Red,"_5");
        snapshot.runningColour = snapshot.openCard.colour;
        Card card = Card.createCard(Colour.Black, "Draw4");

        boolean result = ruleEngine.isPlayableCard(snapshot, card);

        assertTrue(result);
    }
}