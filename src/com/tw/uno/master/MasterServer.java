package com.tw.uno.master;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class MasterServer implements MessageChannelListener {
    private final int totalPlayers;
    private final int totalPacks;
    private ServerSocket serverSocket;
    private List<Player> players = new ArrayList<>();
    private UnoFactory unoFactory;

    public MasterServer(int totalPlayers, int packs, UnoFactory unoFactory) {
        this.totalPlayers = totalPlayers;
        this.totalPacks = packs;
        this.unoFactory = unoFactory;
    }

    public void start() {
        serverSocket = unoFactory.createServerSocket();
        for (int i = 0; i < totalPlayers; i++) {
            unoFactory.acceptPlayerSocket(serverSocket).startListeningForMessages(this);
        }
    }

    @Override
    public void onMessage(MessageChannel messageChannel, Object o) {
        players.add(unoFactory.createPlayer(messageChannel, (String) o));
        messageChannel.send(new Message("wait"));
    }

    @Override
    public void onConnectionClosed(MessageChannel messageChannel) {

    }

    @Override
    public void onError(MessageChannel messageChannel, Exception e) {

    }
}