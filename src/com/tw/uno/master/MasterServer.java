package com.tw.uno.master;

import java.net.ServerSocket;
import java.util.HashMap;

public class MasterServer implements MessageChannelListener {
    private final int totalPlayers;
    private final int totalPacks;
    private ServerSocket serverSocket;
    private UnoFactory unoFactory;
    private HashMap<MessageChannel, ServerPlayer> playerHashMap = new HashMap<>();

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

    private void informAllPlayers() {
        for (MessageChannel messageChannel : playerHashMap.keySet()) {
            messageChannel.send(unoFactory.createMessage("start"));
        }
        HashMap<String, ServerPlayer> serializableMap = createSerializableMap(playerHashMap);
        for (MessageChannel messageChannel : playerHashMap.keySet()) {
            messageChannel.send(unoFactory.createMessage("addPlayers", serializableMap));
        }
    }

    private HashMap<String, ServerPlayer> createSerializableMap(HashMap<MessageChannel, ServerPlayer> playerHashMap) {
        HashMap<String, ServerPlayer> map = new HashMap<>();
        Integer index = 0;
        for (MessageChannel messageChannel : playerHashMap.keySet()) {
            ServerPlayer serverPlayer = playerHashMap.get(messageChannel);
            map.put(index.toString(), serverPlayer);
        }
        return map;
    }

    @Override
    public void onMessage(MessageChannel messageChannel, Object o) {
        Message message = (Message) o;
        if (message.getStatus().equals("player created")) {
            ServerPlayer player = unoFactory.createServerPlayer(message.playerName);
            playerHashMap.put(messageChannel, player);
            messageChannel.send(unoFactory.createMessage("wait"));
            if (playerHashMap.size() == totalPlayers) informAllPlayers();
        }
    }

    @Override
    public void onConnectionClosed(MessageChannel messageChannel) {

    }

    @Override
    public void onError(MessageChannel messageChannel, Exception e) {

    }
}