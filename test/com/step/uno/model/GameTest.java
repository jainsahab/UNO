package com.step.uno.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class GameTest {

    private Player playerMock;
    private Game game;
    private Player player1;
    private Player player2;
    private Player player3;
    private List<Player> players;

    @Before
    public void setup() {
        playerMock = mock(Player.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        player3 = mock(Player.class);
        players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(playerMock);
        game = new Game(1, players, new Pack());
    }

    @Test
    public void on_playing_draw2_the_draw2run_count_should_increment_by_1_and_turn_should_change() {
        Card cardPlayed = Card.createCard(Colour.Yellow, "Draw2");

        assertEquals(0, game.getCurrentPlayerIndex());
        game.playCard(playerMock, cardPlayed, null);

        assertEquals(1, game.getDraw2Run());
        assertEquals(1, game.getCurrentPlayerIndex());
        assertEquals(cardPlayed.colour, game.getRunningColor());
    }

    @Test
    public void on_draw2_a_player_should_draw_a_card_for_draw2run_times() {
        Card cardPlayed = Card.createCard(Colour.Yellow, "Draw2");
        assertEquals(0, game.getCurrentPlayerIndex());
        game.playCard(playerMock, cardPlayed, null);

        game.drawTwoCard(playerMock);

        verify(playerMock, times(2)).take(any(Card.class));
        assertEquals(0, game.getDraw2Run());
    }


    @Test
    public void on_skip_one_player_will_be_skipped() {
        Card cardPlayed = Card.createCard(Colour.Yellow, "Skip");
        assertEquals(0, game.getCurrentPlayerIndex());
        game.playCard(playerMock, cardPlayed, null);

        assertEquals(2, game.getCurrentPlayerIndex());
    }

    @Test
    public void on_reverse_sequence_of_players_should_be_reversed() {
        Card cardPlayed = Card.createCard(Colour.Yellow, "Reverse");
        assertEquals(0, game.getCurrentPlayerIndex());
        game.playCard(playerMock, cardPlayed, null);

        assertEquals(3, game.getCurrentPlayerIndex());
    }


    @Test
    public void on_wild_card_with_color_the_running_color_should_change() {
        Card cardPlayed = Card.createCard(Colour.Black, "Wild");
        assertEquals(0, game.getCurrentPlayerIndex());
        game.playCard(playerMock, cardPlayed, Colour.Yellow);

        assertEquals(Colour.Yellow, game.getRunningColor());
    }

    @Test
    public void on_draw_four_next_player_should_take_four_cards_and_turn_should_change() {
        Card cardPlayed = Card.createCard(Colour.Black, "Draw4");
        assertEquals(0, game.getCurrentPlayerIndex());
        game.playCard(player1, cardPlayed, Colour.Yellow);

        verify(player2, times(4)).take(any(Card.class));
        assertEquals(2, game.getCurrentPlayerIndex());
    }

    @Test
    public void when_first_card_of_openDeck_is_reverse_then_handle_reverse() {
        class PackStub extends Pack {
            @Override
            public Card[] createNewPacks(int numberOfPacks) {
                Card reverse = Card.createCard(Colour.Yellow, "Reverse");
                ArrayList<Card> cards = new ArrayList<>();
                for (int i = 0; i < 108; i++) {
                    cards.add(reverse);
                }
                return cards.toArray(new Card[]{});
            }
        }
        game = new Game(2, players, new PackStub());
        game.initialize();

        assertEquals(false, game.getIsInAscendingOrder());
    }

    @Test
    public void when_first_card_of_openDeck_is_skip_then_handle_skip() {
        class PackStub extends Pack {
            @Override
            public Card[] createNewPacks(int numberOfPacks) {
                Card skip = Card.createCard(Colour.Yellow, "Skip");
                ArrayList<Card> cards = new ArrayList<>();
                for (int i = 0; i < 108; i++) {
                    cards.add(skip);
                }
                return cards.toArray(new Card[]{});
            }
        }
        game = new Game(2, players, new PackStub());
        game.initialize();

        assertEquals(1, game.getCurrentPlayerIndex());
    }

    @Test
    public void when_first_card_of_openDeck_is_wild_then_handle_wild() {
        class PackStub extends Pack {
            @Override
            public Card[] createNewPacks(int numberOfPacks) {
                Card wild = Card.createCard(Colour.Black, "Wild");
                ArrayList<Card> cards = new ArrayList<>();
                for (int i = 0; i < 108; i++) {
                    cards.add(wild);
                }
                return cards.toArray(new Card[]{});
            }
        }
        game = new Game(2, players, new PackStub());
        game.initialize();

        assertEquals(Colour.Green, game.getRunningColor());
    }

    @Test
    public void when_first_card_of_openDeck_is_Draw4_then_handle_Draw4() {
        class PackStub extends Pack {
            @Override
            public Card[] createNewPacks(int numberOfPacks) {
                Card draw4 = Card.createCard(Colour.Black, "Draw4");
                ArrayList<Card> cards = new ArrayList<>();
                for (int i = 0; i < 108; i++) {
                    cards.add(draw4);
                }
                return cards.toArray(new Card[]{});
            }
        }
        game = new Game(2, players, new PackStub());
        game.initialize();

        assertEquals(Colour.Green, game.getRunningColor());
        assertEquals(1, game.getCurrentPlayerIndex());
    }

    @Test
    public void when_first_card_of_openDeck_is_Draw2_then_handle_Draw2() {
        class PackStub extends Pack {
            @Override
            public Card[] createNewPacks(int numberOfPacks) {
                Card draw2 = Card.createCard(Colour.Yellow, "Draw2");
                ArrayList<Card> cards = new ArrayList<>();
                for (int i = 0; i < 108; i++) {
                    cards.add(draw2);
                }
                return cards.toArray(new Card[]{});
            }
        }
        game = new Game(2, players, new PackStub());
        game.initialize();

        assertEquals(1, game.getDraw2Run());
    }

}