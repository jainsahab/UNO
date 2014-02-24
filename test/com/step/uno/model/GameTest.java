package com.step.uno.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameTest {

    private Player playerMock;
    private Game game;
    private Player player1;
    private Player player2;
    private Player player3;

    @Before
    public void setup() {
        playerMock = mock(Player.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        player3 = mock(Player.class);
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(playerMock);
        game = new Game(1, players);
    }

    @Test
    public void on_initializing_game_each_player_should_get_seven_cards() {
        game.initialize();
        verify(player1, times(7)).take(any(Card.class));
        verify(player2, times(7)).take(any(Card.class));
        verify(player3, times(7)).take(any(Card.class));
        assertNotNull(game.getCurrentPlayerIndex());
    }

    @Test
    public void on_playing_draw2_the_draw2run_count_should_increment_by_1_and_turn_should_change() {
        Card cardPlayed = Card.createCard(Colour.Yellow, "Draw2");

        assertEquals(0,game.getCurrentPlayerIndex());
        game.playCard(playerMock, cardPlayed, null);

        assertEquals(1, game.getDraw2Run());
        assertEquals(1, game.getCurrentPlayerIndex());
        assertEquals(cardPlayed.colour, game.getRunningColor());
    }

    @Test
    public void on_draw2_a_player_should_draw_a_card_for_draw2run_times() {
        Card cardPlayed = Card.createCard(Colour.Yellow,"Draw2");
        assertEquals(0,game.getCurrentPlayerIndex());
        game.playCard(playerMock, cardPlayed, null);

        game.drawTwoCard(playerMock);

        verify(playerMock, times(2)).take(any(Card.class));
        assertEquals(0, game.getDraw2Run());
    }


    @Test
    public void on_skip_one_player_will_be_skipped() {
        Card cardPlayed = Card.createCard(Colour.Yellow,"Skip");
        assertEquals(0,game.getCurrentPlayerIndex());
        game.playCard(playerMock,cardPlayed, null);

        assertEquals(2, game.getCurrentPlayerIndex());
    }

    @Test
    public void on_reverse_sequence_of_players_should_be_reversed() {
        Card cardPlayed = Card.createCard(Colour.Yellow,"Reverse");
        assertEquals(0,game.getCurrentPlayerIndex());
        game.playCard(playerMock,cardPlayed, null);

        assertEquals(3, game.getCurrentPlayerIndex());
    }


    @Test
    public void on_wild_card_with_color_the_running_color_should_change() {
        Card cardPlayed = Card.createCard(Colour.Black,"Wild");
        assertEquals(0,game.getCurrentPlayerIndex());
        game.playCard(playerMock,cardPlayed,Colour.Yellow);

        assertEquals(Colour.Yellow,game.getRunningColor());
    }
}
