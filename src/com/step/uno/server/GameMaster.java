package com.step.uno.server;

import com.step.communication.channel.MessageChannel;
import com.step.communication.factory.CommunicationFactory;
import com.step.communication.server.MessageServer;
import com.step.communication.server.MessageServerListener;
import com.step.uno.factory.UnoFactory;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.model.Game;
import com.step.uno.model.Player;

import java.util.ArrayList;
import java.util.List;

public class GameMaster implements MessageServerListener, PlayerProxyObserver {
    private final int totalPlayers;
    private final int totalPacks;
    private final CommunicationFactory communicationFactory;
    private UnoFactory unoFactory;
    private MessageServer server;
    private final List<PlayerProxy> proxies = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private Game game;

    public GameMaster(int totalPlayers, int packs, CommunicationFactory communicationFactory, UnoFactory unoFactory) {
        this.totalPlayers = totalPlayers;
        this.totalPacks = packs;
        this.communicationFactory = communicationFactory;
        this.unoFactory = unoFactory;
    }

    public void start() {
        System.out.println("Server started : ");
        server = communicationFactory.createMessageServer();
        server.startListeningForConnections(this);
    }

    @Override
    public void onNewConnection(MessageChannel channel) {
        if (proxies.size() == totalPlayers) {
            channel.stop();
            return;
        }
        PlayerProxy proxy = unoFactory.createPlayerProxy(channel, this);
        proxy.start();
        proxies.add(proxy);
        System.out.println("New player registered");
    }

    private void startGame() {
        System.out.println("Game started : ");
        game = unoFactory.createGame(totalPacks, players);
        game.initialize();
        sendSnapshot();
    }

    private void sendSnapshot() {
        for (PlayerProxy proxy : proxies)
            proxy.sendSnapshot(game);
    }

    @Override
    public void onError(Exception e) {

    }

    @Override
    public void onPlayerRegistered(Player player) {
        players.add(player);
        if (players.size() == totalPlayers)
            startGame();
    }

    @Override
    public void onPlayerPlayed(Player player, Card card, Colour newColour) {
        game.playCard(player, card);
        sendSnapshot();
    }

    @Override
    public void onPlayerDrewCard(Player player) {
        game.drawCard(player);
        sendSnapshot();
    }
}