package com.tw.uno.master;

import com.tw.uno.view.Loading;
import com.tw.uno.view.LoginForm;
import com.tw.uno.view.LoginFormListener;

import java.io.IOException;
import java.net.Socket;

public class UnoClient implements LoginFormListener, MessageChannelListener {
    MessageChannel channel;
    private static LoginForm loginForm;

    public static void main(String[] args) {
        loginForm = new LoginForm(new UnoClient());
    }

    @Override
    public void notify(String masterAddress, String playerName) {
        Socket socket;
        try {
            socket = new Socket(masterAddress, 8080);
            channel = new MessageChannel(socket);
            channel.send(playerName);
            channel.startListeningForMessages(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loginForm.setVisible(false);
    }

    @Override
    public void onMessage(MessageChannel messageChannel, Object o) {
        Message message = (Message)o;
        if(message.getStatus().equals("wait"))
            new Loading();
    }

    @Override
    public void onConnectionClosed(MessageChannel messageChannel) {

    }

    @Override
    public void onError(MessageChannel messageChannel, Exception e) {

    }
}