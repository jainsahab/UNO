package com.step.uno.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameTest {

    private Player playerMock;
    private Game game;

    @Before
    public void setup() {
        playerMock = mock(Player.class);
        ArrayList<Player> players = new ArrayList<>();
        players.add(playerMock);
        players.add(playerMock);
        game = new Game(1, players);
    }

    @Test
    public void on_playing_draw2_the_draw2run_count_should_increment_by_1_and_turn_should_change() {
        Card cardPlayed = Card.createCard(Colour.Yellow, "Draw2");

        game.playCard(playerMock, cardPlayed);

        assertEquals(1, game.getDraw2Run());
        assertEquals(1, game.getCurrentPlayerIndex());
        assertEquals(cardPlayed.colour, game.getRunningColor());
    }

    @Test
    public void on_draw2_a_player_should_draw_a_card_for_draw2run_times() {
        Card cardPlayed = Card.createCard(Colour.Yellow,"Draw2");
        game.playCard(playerMock, cardPlayed);

        game.drawTwoCard(playerMock);

        verify(playerMock,times(2)).take(any(Card.class));
    }
}
