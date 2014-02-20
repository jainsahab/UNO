package com.step.uno.controller;

import com.step.uno.client.GameClient;
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
}
