package com.step.uno.controller;

import com.step.uno.client.GameClient;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.view.UnoView;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ControllerTest {
    @Test
    public void starting_controller_displays_login_form() {
        GameClient gameClientMock = mock(GameClient.class);
        UnoView viewMock = mock(UnoView.class);
        new Controller(gameClientMock).start(viewMock);
        verify(viewMock, times(1)).showLoginForm();
    }

    @Test
    public void onJoin_hides_login_form_and_starts_game_client() {
        GameClient gameClientMock = mock(GameClient.class);
        UnoView viewMock = mock(UnoView.class);
        Controller controller = new Controller(gameClientMock);
        controller.start(viewMock);
        controller.onJoin("me", "serverAddress");
        verify(viewMock, times(1)).hideLoginForm();
        verify(gameClientMock, times(1)).start("me", "serverAddress", controller);
    }

    @Test
    public void informs_game_client_when_player_plays_a_card() {
        GameClient gameClientMock = mock(GameClient.class);
        Controller controller = new Controller(gameClientMock);
        Card card = Card.createCard(Colour.Black, "_4");
        controller.cardPlayed(card);
        verify(gameClientMock, times(1)).play(card);
    }
}
