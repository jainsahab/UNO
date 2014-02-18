package com.tw.uno.master;

import com.tw.uno.view.LoadingForm;
import com.tw.uno.view.LoginForm;
import com.tw.uno.view.LoginFormListener;
import com.tw.uno.view.Screen;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class UnoClient implements LoginFormListener, MessageChannelListener {
    private final LoadingForm loadingForm;
    private MessageChannel channel;
    private static LoginForm loginForm;
    private ClientPlayer player;
    private Screen screen;

    public UnoClient(LoginForm loginForm, LoadingForm loadingForm, Screen screen) {

        this.loginForm = loginForm;
        this.loadingForm = loadingForm;
        this.screen = screen;
    }

    public void start() {
        loginForm.addListener(this);
        loginForm.setVisible(true);
    }

    @Override
    public void notify(String masterAddress, String playerName) {
        Socket socket;
        try {
            socket = new Socket(masterAddress, 8080);
            player = new ClientPlayer(playerName);
            channel = new MessageChannel(socket);
            channel.send(new Message("player created", playerName));
            channel.startListeningForMessages(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        loginForm.setVisible(false);
    }

    @Override
    public void onMessage(MessageChannel messageChannel, Object o) {
        Message message = (Message) o;
        if (message.getStatus().equals("wait")) {
            loginForm.setVisible(false);
            loadingForm.setVisible(true);
        }
        if (message.getStatus().equals("start")) {
            loadingForm.setVisible(false);
            screen.setVisible(true);
        }
        if (message.getStatus().equals("addPlayers")) {
            ArrayList<ServerPlayer> players = message.players;
            for (ServerPlayer player : players) {
                screen.addPlayer(player);
            }
        }
    }

    @Override
    public void onConnectionClosed(MessageChannel messageChannel) {

    }

    @Override
    public void onError(MessageChannel messageChannel, Exception e) {

    }
}