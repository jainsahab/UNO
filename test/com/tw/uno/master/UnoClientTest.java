package com.tw.uno.master;

import com.tw.uno.view.LoadingForm;
import com.tw.uno.view.LoginForm;
import com.tw.uno.view.LoginFormListener;
import com.tw.uno.view.Screen;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UnoClientTest {
    Screen screen = mock(Screen.class);
    LoginForm loginForm = mock(LoginForm.class);
    LoadingForm loadingForm  = mock(LoadingForm.class);
    MessageChannel messageChannel = mock(MessageChannel.class);
    UnoClient client = new UnoClient(loginForm,loadingForm,screen);

    @Test
    public void startingClientShouldAddLoginFormListenerAndDisplayLoginForm() {
        client.start();

        verify(loginForm,times(1)).addListener(any(LoginFormListener.class));
        verify(loginForm,times(1)).setVisible(true);
    }

    @Test
    public void onNewMessageWaitClientShouldRenderWaitingScreen() {

        Message message= new Message("wait");

        client.onMessage(messageChannel, message);

        verify(loginForm, times(1)).setVisible(false);
        verify(loadingForm,times(1)).setVisible(true);
    }

    @Test
    public void onNewMessageStartClientShouldRenderMainGameScreen() {

        Message message= new Message("start");

        client.onMessage(messageChannel, message);

        verify(loadingForm, times(1)).setVisible(false);
        verify(screen,times(1)).setVisible(true);
    }
}