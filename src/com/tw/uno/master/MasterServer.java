package com.tw.uno.master;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class MasterServer {
    private final int totalPlayers;
    private final int totalPacks;
    private ServerSocket serverSocket;
    private List<Client> players = new ArrayList<>();
    private UnoFactory unoFactory;

    public MasterServer(int totalPlayers, int packs, UnoFactory unoFactory) {
        this.unoFactory = unoFactory;
        this.totalPlayers = totalPlayers;
        this.totalPacks = packs;
    }

    public void start() {
        serverSocket = unoFactory.createServerSocket();
        for (int i = 0; i < totalPlayers; i++) {
            players.add(unoFactory.acceptPlayer(serverSocket));
        }
    }

}