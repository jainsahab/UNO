package com.step.uno.server;

import com.step.communication.channel.MessageChannel;
import com.step.communication.factory.CommunicationFactory;
import com.step.communication.server.MessageServer;
import com.step.uno.factory.UnoFactory;
import com.step.uno.model.Game;
import com.step.uno.model.Player;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class GameMasterTest {

    private CommunicationFactoryStub communicationFactoryStub = new CommunicationFactoryStub();
    private UnoFactoryStub unoFactoryStub = new UnoFactoryStub();
    private MessageChannel messageChannelMock = mock(MessageChannel.class);

    private class UnoFactoryStub extends UnoFactory {
        private PlayerProxy playerProxy = mock(PlayerProxy.class);
        public Game game = mock(Game.class);

        @Override
        public PlayerProxy createPlayerProxy(MessageChannel channel, PlayerProxyObserver proxyObserver) {
            return playerProxy;
        }

        @Override
        public Game createGame(int totalPacks, List<Player> players) {
            return game;
        }
    }

    private class CommunicationFactoryStub extends CommunicationFactory {

        public final MessageServer messageServer = mock(MessageServer.class);

        @Override
        public MessageServer createMessageServer() {
            return messageServer;
        }
    }

    @Test
    public void starting_server_starts_accepting_connection() {
        GameMaster gameMaster = new GameMaster(2, 1, communicationFactoryStub, unoFactoryStub);
        gameMaster.start();
        verify(communicationFactoryStub.messageServer, times(1)).startListeningForConnections(gameMaster);
    }

    @Test
    public void on_new_connection_player_proxy_is_created_and_started_and_added() {
        GameMaster gameMaster = new GameMaster(1, 1, communicationFactoryStub, unoFactoryStub);
        gameMaster.onNewConnection(messageChannelMock);

        verify(unoFactoryStub.playerProxy, times(1)).start();
    }

    @Test
    public void after_specified_number_of_players_join_reject_connection() {
        GameMaster gameMaster = new GameMaster(1, 1, communicationFactoryStub, unoFactoryStub);
        gameMaster.onNewConnection(messageChannelMock);
        gameMaster.onNewConnection(messageChannelMock);

        verify(unoFactoryStub.playerProxy, times(1)).start();
        verify(messageChannelMock, times(1)).stop();
    }

    @Test
    public void starts_a_game_when_all_players_are_registered() {
        GameMaster gameMaster = new GameMaster(1, 1, communicationFactoryStub, unoFactoryStub);
        gameMaster.onNewConnection(messageChannelMock);
        gameMaster.onPlayerRegistered(mock(Player.class));

        verify(unoFactoryStub.game, times(1)).initialize();
    }

    @Test
    public void send_snapshot_to_all_players_when_game_started() {
        GameMaster gameMaster = new GameMaster(1, 1, communicationFactoryStub, unoFactoryStub);
        gameMaster.onNewConnection(messageChannelMock);
        gameMaster.onPlayerRegistered(mock(Player.class));

        verify(unoFactoryStub.playerProxy, times(1)).sendSnapshot(unoFactoryStub.game);
    }
}
