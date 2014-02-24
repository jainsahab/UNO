package com.step.uno.controller;

import com.step.uno.client.GameClient;
import com.step.uno.messages.Snapshot;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.view.UnoView;
import org.junit.Test;

import java.awt.*;

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
        GameClientController gameClientController = new GameClientController(gameClientMock);
        Snapshot snapshot = new Snapshot();
        snapshot.draw2Run = 1;
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
}
