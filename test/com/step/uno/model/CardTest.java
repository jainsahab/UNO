package com.step.uno.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CardTest {
    @Test
    public void on_any_number_card_the_card_of_same_number_should_be_playable() {
        Card openCard = Card.createCard(Colour.Blue, "_1");
        Card card = Card.createCard(Colour.Yellow, "_1");
        boolean result = openCard.isPlayableCard(card, 0, openCard.colour);

        assertTrue(result);
    }

    @Test
    public void on_any_number_card_the_card_of_same_colour_should_be_playable() {
        Card openCard = Card.createCard(Colour.Blue, "_1");
        Card card = Card.createCard(Colour.Blue, "_3");
        boolean result = openCard.isPlayableCard(card, 0, openCard.colour);

        assertTrue(result);
    }

    @Test
    public void on_any_number_card_the_sign_or_color_of_another_card_does_not_match_then_it_is_unplayable() {
        Card openCard = Card.createCard(Colour.Blue, "_1");
        Card card = Card.createCard(Colour.Green, "Reverse");
        boolean result = openCard.isPlayableCard(card, 0, openCard.colour);

        assertFalse(result);
    }

    @Test
    public void on_any_draw_performed_draw_two_card_any_card_of_same_color_is_playable() {
        Card openCard = Card.createCard(Colour.Blue, "Draw2");
        Card card = Card.createCard(Colour.Blue, "_9");
        boolean result = openCard.isPlayableCard(card, 0, openCard.colour);

        assertTrue(result);
    }

    @Test
    public void on_any_draw_performed_draw_two_card_any_card_of_same_sign_is_playable() {
        Card openCard = Card.createCard(Colour.Blue, "Draw2");
        Card card = Card.createCard(Colour.Green, "Draw2");
        boolean result = openCard.isPlayableCard(card, 0, openCard.colour);

        assertTrue(result);
    }

    @Test
    public void on_any_draw_performed_draw_two_card_any_card_of_same_sign_and_same_color_is_playable() {
        Card openCard = Card.createCard(Colour.Green, "Draw2");
        Card card = Card.createCard(Colour.Green, "Draw2");

        boolean result = openCard.isPlayableCard(card, 0, openCard.colour);

        assertTrue(result);
    }

    @Test
    public void on_any_draw_performed_draw_two_card_any_card_of_different_sign_and_color_is_unplayable() {
        Card openCard = Card.createCard(Colour.Green, "Draw2");
        Card card = Card.createCard(Colour.Red, "_2");

        boolean result = openCard.isPlayableCard(card, 0, openCard.colour);

        assertFalse(result);
    }

    @Test
    public void on_any_draw_two_card_any_draw_two_card_is_playable() {
        Card openCard = Card.createCard(Colour.Green, "Draw2");
        Card card = Card.createCard(Colour.Red, "Draw2");

        boolean result = openCard.isPlayableCard(card, 1, openCard.colour);

        assertTrue(result);
    }

    @Test
    public void on_any_draw_two_card_the_card_of_same_colour_with_sign_other_than_draw_two_card_is_unplayable() {
        Card openCard = Card.createCard(Colour.Green, "Draw2");
        Card card = Card.createCard(Colour.Green, "_2");

        boolean result = openCard.isPlayableCard(card, 1, openCard.colour);

        assertFalse(result);
    }

    @Test
    public void on_any_skip_card_the_card_of_same_colour_is_playable() {
        Card openCard = Card.createCard(Colour.Green, "Skip");
        Card card = Card.createCard(Colour.Green, "_5");

        boolean result = openCard.isPlayableCard(card, 0, openCard.colour);

        assertTrue(result);
    }

    @Test
    public void on_any_skip_card_the_card_of_same_sign_is_playable() {
        Card openCard = Card.createCard(Colour.Green, "Skip");
        Card card = Card.createCard(Colour.Blue, "Skip");

        boolean result = openCard.isPlayableCard(card, 0, openCard.colour);

        assertTrue(result);
    }

    @Test
    public void on_any_skip_card_the_card_of_same_colour_and_same_sign_is_playable() {
        Card openCard = Card.createCard(Colour.Green, "Skip");
        Card card = Card.createCard(Colour.Green, "Skip");

        boolean result = openCard.isPlayableCard(card, 0, openCard.colour);

        assertTrue(result);
    }

    @Test
    public void on_any_skip_card_the_card_of_different_colour_and_different_sign_is_unplayable() {
        Card openCard = Card.createCard(Colour.Green, "Skip");
        Card card = Card.createCard(Colour.Blue, "_2");

        boolean result = openCard.isPlayableCard(card, 0, openCard.colour);

        assertFalse(result);
    }

    @Test
    public void on_any_reverse_card_the_card_of_same_colour_is_playable() {
        Card openCard = Card.createCard(Colour.Green, "Reverse");
        Card card = Card.createCard(Colour.Green, "_5");

        boolean result = openCard.isPlayableCard(card, 0, openCard.colour);

        assertTrue(result);
    }

    @Test
    public void on_any_reverse_card_the_card_of_same_sign_is_playable() {
        Card openCard = Card.createCard(Colour.Green, "Reverse");
        Card card = Card.createCard(Colour.Yellow, "Reverse");

        boolean result = openCard.isPlayableCard(card, 0, openCard.colour);

        assertTrue(result);
    }

    @Test
    public void on_any_reverse_card_the_card_of_same_colour_and_same_sign_is_playable() {
        Card openCard = Card.createCard(Colour.Green, "Reverse");
        Card card = Card.createCard(Colour.Green, "Reverse");

        boolean result = openCard.isPlayableCard(card, 0, openCard.colour);

        assertTrue(result);
    }


    @Test
    public void on_any_reverse_card_the_card_of_different_colour_and_different_sign_is_unplayable() {
        Card openCard = Card.createCard(Colour.Green, "Reverse");
        Card card = Card.createCard(Colour.Blue, "_2");

        boolean result = openCard.isPlayableCard(card, 0, openCard.colour);

        assertFalse(result);
    }

    @Test
    public void on_any_card_wild_card_is_playable() {
        Card openCard = Card.createCard(Colour.Green, "Reverse");
        Card card = Card.createCard(Colour.Black, "Wild");

        boolean result = openCard.isPlayableCard(card, 0, openCard.colour);

        assertTrue(result);
    }

    @Test
    public void on_draw_two_card_wild_card_is_unplayable() {
        Card openCard = Card.createCard(Colour.Green, "Draw2");
        Card card = Card.createCard(Colour.Black, "Wild");

        boolean result = openCard.isPlayableCard(card, 1, openCard.colour);

        assertFalse(result);
    }


    @Test
    public void on_draw_two_card_wild_draw_4_card_is_unplayable() {
        Card openCard = Card.createCard(Colour.Green, "Draw2");
        Card card = Card.createCard(Colour.Black, "Draw4");

        boolean result = openCard.isPlayableCard(card, 1, openCard.colour);

        assertFalse(result);
    }
}