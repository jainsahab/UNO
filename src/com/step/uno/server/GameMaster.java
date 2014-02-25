package com.step.uno.server;

import com.step.communication.channel.MessageChannel;
import com.step.communication.factory.CommunicationFactory;
import com.step.communication.server.MessageServer;
import com.step.communication.server.MessageServerListener;
import com.step.uno.factory.UnoFactory;
import com.step.uno.messages.GameResult;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.model.Game;
import com.step.uno.model.Player;

import java.util.ArrayList;
import java.util.List;

public class GameMaster implements MessageServerListener, PlayerProxyObserver {
    private int totalPlayers;
    private int totalPacks;
    private final CommunicationFactory communicationFactory;
    private UnoFactory unoFactory;
    private MessageServer server;
    private final List<PlayerProxy> proxies = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private Game game;

    public GameMaster(CommunicationFactory communicationFactory, UnoFactory unoFactory) {
        this.communicationFactory = communicationFactory;
        this.unoFactory = unoFactory;
    }

    public void start(int numberOfPlayers, int numberOfPacks) {
        System.out.println("Server started : ");
        this.totalPlayers = numberOfPlayers;
        this.totalPacks = numberOfPacks;
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
        System.out.println("New player registered.");
    }

    private void startGame() {
        System.out.println("Game started : ");
        game = unoFactory.createGame(totalPacks, players);
        game.initialize();
        sendGameSnapshot();
    }

    private void sendGameSnapshot() {
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
        game.updateLogOnPlayerPlayed(player, card);
        game.playCard(player, card, newColour);
        sendGameSnapshot();
        if (player.hasWon()) sendResult();
    }

    private void sendResult() {
        GameResult result = game.populateResult();
        for (PlayerProxy proxy : proxies) {
            proxy.sendResultSnapshot(result);
        }
    }

    @Override
    public void onPlayerDrewCard(Player player) {
        game.updateLogOnPlayerDrewCard(player, "1");
        game.drawCard(player);
        sendGameSnapshot();
    }

    @Override
    public void onPlayerDrewTwoCard(Player player) {
        game.updateLogOnPlayerDrewCard(player, "2");
        game.drawTwoCard(player);
        sendGameSnapshot();
    }

    @Override
    public void onPlayerDeclaredUno(Player player) {
        game.updateLogOnPlayerDeclaredUno(player);
        player.declaredUno();
        sendGameSnapshot();
    }

    @Override
    public void onPlayerCaught(String name, int playerIndex) {
        game.updateLogOnPlayerCaught(name);
        Player player = players.get(playerIndex);
        game.onPlayerCaughtOnUno(player);
        sendGameSnapshot();
    }
}