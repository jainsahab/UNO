package com.step.uno.server;

import com.step.communication.channel.MessageChannel;
import com.step.uno.messages.DrawCardAction;
import com.step.uno.messages.Snapshot;
import com.step.uno.model.Game;
import com.step.uno.model.Player;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PlayerProxyTest {

    private MessageChannel channel = mock(MessageChannel.class);
    private PlayerProxyObserver proxyObserver = mock(PlayerProxyObserver.class);
    private Game gameMock;

    @Test
    public void testStart() {
        PlayerProxy playerProxy = new PlayerProxy(channel, proxyObserver);
        playerProxy.start();
        verify(channel, times(1)).startListeningForMessages(playerProxy);
    }

    @Test
    public void testOnMessageWhenPlayerDrawsCard() {
        PlayerProxy playerProxy = new PlayerProxy(channel, proxyObserver);
        playerProxy.onMessage(channel, new DrawCardAction());
        verify(proxyObserver, times(1)).onPlayerDrewCard(any(Player.class));
    }

    @Test
    public void testSendSnapshot() {
        PlayerProxy playerProxy = new PlayerProxy(channel, proxyObserver);
        gameMock = mock(Game.class);
        playerProxy.sendSnapshot(gameMock);
        verify(gameMock, times(1)).populate(any(Snapshot.class), any(Player.class));
        verify(channel, times(1)).send(any(Snapshot.class));
    }
}
