package com.step.uno.model;

import com.step.uno.messages.Snapshot;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PlayerTest {
    @Test
    public void players_takes_card_and_adds_to_it_in_list() {
        Player player = new Player("name");
        Card card1 = Card.createCard(Colour.Blue, "_1");
        Card card2 = Card.createCard(Colour.Red, "_2");
        player.take(card1);
        player.take(card2);
        Snapshot snapshot = new Snapshot();
        player.populateSelf(snapshot);
        assertEquals(snapshot.myCards.length, 2);
    }

    @Test
    public void remove_card_from_player_list_when_played() {
        Player player = new Player("name");
        Card card1 = Card.createCard(Colour.Blue, "_1");
        Card card2 = Card.createCard(Colour.Red, "_2");
        player.take(card1);
        player.take(card2);
        player.play(card1);
        Snapshot snapshot = new Snapshot();
        player.populateSelf(snapshot);
        assertEquals(snapshot.myCards.length, 1);
    }

    @Test
    public void player_populates_summary_in_snapshot() {
        Player player = new Player("name");
        Card card1 = Card.createCard(Colour.Blue, "_1");
        Card card2 = Card.createCard(Colour.Red, "_2");
        player.take(card1);
        player.take(card2);
        PlayerSummary summary = new PlayerSummary("name", 2, false);
        assertEquals(summary, player.generateSummary());
    }
}