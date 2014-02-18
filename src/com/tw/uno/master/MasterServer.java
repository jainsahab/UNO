package com.tw.uno.master;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MasterServer implements MessageChannelListener {
    private final int totalPlayers;
    private final int totalPacks;
    private ServerSocket serverSocket;
    private UnoFactory unoFactory;
    private HashMap<MessageChannel, ServerPlayer> playerHashMap = new HashMap<>();
    private ArrayList<ServerPlayer> playersInOrder = new ArrayList<>();

    public MasterServer(int totalPlayers, int packs, UnoFactory unoFactory) {
        this.totalPlayers = totalPlayers;
        this.totalPacks = packs;
        this.unoFactory = unoFactory;
    }

    public void start() {
        serverSocket = unoFactory.createServerSocket();
        for (int i = 0; i < totalPlayers; i++) {
            MessageChannel messageChannel = unoFactory.acceptPlayerSocket(serverSocket);
            messageChannel.startListeningForMessages(this);
        }
    }

    private void startGame() {
        for (MessageChannel messageChannel : playerHashMap.keySet()) {
            playersInOrder.add(playerHashMap.get(messageChannel));
        }
        Collections.shuffle(playersInOrder);
        for (MessageChannel messageChannel : playerHashMap.keySet()) {
            messageChannel.send(unoFactory.createMessage("start"));
            messageChannel.send(unoFactory.createMessage("addPlayers", playersInOrder));
        }
    }

    @Override
    public void onMessage(MessageChannel messageChannel, Object o) {
        Message message = (Message) o;
        if (message.getStatus().equals("player created")) {
            ServerPlayer player = unoFactory.createServerPlayer(message.playerName);
            playerHashMap.put(messageChannel, player);
            messageChannel.send(unoFactory.createMessage("wait"));
            if (playerHashMap.size() == totalPlayers) startGame();
        }
    }

    @Override
    public void onConnectionClosed(MessageChannel messageChannel) {

    }

    @Override
    public void onError(MessageChannel messageChannel, Exception e) {

    }
}