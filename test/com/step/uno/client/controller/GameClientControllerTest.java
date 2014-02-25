package com.step.uno.client.controller;

import com.step.uno.client.GameClient;
import com.step.uno.client.view.PlayerButton;
import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.client.view.UnoView;
import com.step.uno.model.PlayerSummary;
import com.step.uno.rules.RuleEngine;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class GameClientControllerTest {
    GameClient gameClientMock = mock(GameClient.class);
    @Test
    public void starting_controller_displays_login_form() {
        UnoView viewMock = mock(UnoView.class);
        new GameClientController(gameClientMock).start(viewMock);
        verify(viewMock, times(1)).showLoginForm();
    }

    @Test
    public void onJoin_hides_login_form_and_starts_game_client() {
        UnoView viewMock = mock(UnoView.class);
        GameClientController gameClientController = new GameClientController(gameClientMock);
        gameClientController.start(viewMock);
        gameClientController.onJoin("me", "serverAddress");
        verify(viewMock, times(1)).hideLoginForm();
        verify(gameClientMock, times(1)).start("me", "serverAddress", gameClientController);
    }

    @Test
    public void informs_game_client_when_player_plays_a_card() {
        GameClientController gameClientController = new GameClientController(gameClientMock);
        Card card = Card.createCard(Colour.Yellow, "_2");
        gameClientController.cardPlayed(card);
        verify(gameClientMock, times(1)).play(card);
    }

    @Test
    public void informs_game_client_to_draw_cards_as_per_draw2_run_when_clicked_on_draw_button() {
        Card[] cards = {Card.createCard(Colour.Yellow,"_9"),Card.createCard(Colour.Blue,"Draw4")};
        GameClientController gameClientController = new GameClientController(gameClientMock);
        Snapshot snapshot = new Snapshot();
        snapshot.draw2Run = 1;
        snapshot.myCards = cards;
        snapshot.openCard = Card.createCard(Colour.Blue,"Draw2");
        snapshot.playerSummaries = new PlayerSummary[]{};
        gameClientController.start(mock(UnoView.class));
        gameClientController.update(snapshot);

        gameClientController.drawCard();

        verify(gameClientMock,times(1)).drawTwo();
        verify(gameClientMock,never()).draw();
    }

    @Test
    public void when_player_plays_wild_card_change_color_dialog_should_open() {
        GameClientController gameClientController = new GameClientController(gameClientMock);
        UnoView unoViewMock = mock(UnoView.class);
        gameClientController.start(unoViewMock);
        Card card = Card.createCard(Colour.Black,"Wild");

        gameClientController.cardPlayed(card);

        verify(unoViewMock,times(1)).showChangeColorDialog();
        verify(gameClientMock,never()).play(any(Card.class),any(Colour.class));
    }

    @Test
    public void on_selecting_new_color_color_dialog_should_hide_and_game_client_should_be_notified() {
        GameClientController gameClientController = new GameClientController(gameClientMock);
        UnoView unoViewMock = mock(UnoView.class);
        gameClientController.start(unoViewMock);
        Card card = Card.createCard(Colour.Black,"Wild");
        gameClientController.cardPlayed(card);

        gameClientController.setNewColor(Color.GREEN);

        verify(unoViewMock,times(1)).hideChangeColorDialog();
        verify(gameClientMock,times(1)).play(card,Colour.Green);
    }

    @Test
    public void if_you_dont_have_a_card_of_running_colour_then_draw4_is_playable() {
        GameClientController controller = new GameClientController(gameClientMock);
        UnoView unoViewMock = mock(UnoView.class);
        controller.start(unoViewMock);
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Red,"_5");
        snapshot.runningColour = snapshot.openCard.colour;
        Card draw4 = Card.createCard(Colour.Black, "Draw4");
        Card green2 = Card.createCard(Colour.Green, "_2");
        Card blue3 = Card.createCard(Colour.Blue, "_3");
        snapshot.myCards = new Card[]{green2
                , blue3, draw4
        };
        snapshot.playerSummaries = new PlayerSummary[]{};

        controller.update(snapshot);

        verify(unoViewMock,times(1)).addCard(blue3,false);
        verify(unoViewMock,times(1)).addCard(green2,false);
        verify(unoViewMock, times(1)).addCard(draw4,true);
    }

    @Test
    public void if_you_have_a_card_of_running_colour_then_draw4_is_unplayable() {
        GameClientController controller = new GameClientController(gameClientMock);
        UnoView unoViewMock = mock(UnoView.class);
        controller.start(unoViewMock);
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Green,"_5");
        snapshot.runningColour = snapshot.openCard.colour;
        Card draw4 = Card.createCard(Colour.Black, "Draw4");
        Card green2 = Card.createCard(Colour.Green, "_2");
        Card blue3 = Card.createCard(Colour.Blue, "_3");
        snapshot.myCards = new Card[]{green2
                , blue3, draw4
        };
        snapshot.playerSummaries = new PlayerSummary[]{};

        controller.update(snapshot);

        verify(unoViewMock,times(1)).addCard(blue3,false);
        verify(unoViewMock,times(1)).addCard(green2,true);
        verify(unoViewMock, times(1)).addCard(draw4,false);
    }

    @Test
    public void on_other_player_turn_my_cards_should_be_disabled() {
        GameClientController controller = new GameClientController(gameClientMock);
        UnoView unoViewMock = mock(UnoView.class);
        controller.start(unoViewMock);
        Snapshot snapshot = new Snapshot();
        snapshot.openCard = Card.createCard(Colour.Green,"_5");
        snapshot.runningColour = snapshot.openCard.colour;
        Card draw4 = Card.createCard(Colour.Black, "Draw4");
        Card green2 = Card.createCard(Colour.Green, "_2");
        Card blue3 = Card.createCard(Colour.Blue, "_3");
        snapshot.myCards = new Card[]{green2
                , blue3, draw4
        };
        snapshot.playerSummaries = new PlayerSummary[]{};
        snapshot.currentPlayerIndex = 0;
        snapshot.myPlayerIndex = 1;

        controller.update(snapshot);

        verify(unoViewMock,times(1)).addCard(blue3,false);
        verify(unoViewMock,times(1)).addCard(green2,false);
        verify(unoViewMock, times(1)).addCard(draw4,false);
    }
}
