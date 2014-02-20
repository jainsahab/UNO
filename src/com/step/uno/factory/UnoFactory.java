package com.step.uno.factory;

import com.step.communication.channel.MessageChannel;
import com.step.uno.model.Game;
import com.step.uno.model.Player;
import com.step.uno.server.PlayerProxy;
import com.step.uno.server.PlayerProxyObserver;

import java.util.List;

public class UnoFactory {
    public PlayerProxy createPlayerProxy(MessageChannel channel, PlayerProxyObserver proxyObserver) {
        return new PlayerProxy(channel, proxyObserver);
    }

    public Game createGame(int totalPacks, List<Player> players) {
        return new Game(totalPacks, players);
    }
}
