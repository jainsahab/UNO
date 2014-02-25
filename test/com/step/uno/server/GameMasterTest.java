package com.step.uno.server;

import com.step.communication.channel.MessageChannel;
import com.step.communication.factory.CommunicationFactory;
import com.step.communication.server.MessageServer;
import com.step.uno.factory.UnoFactory;
import com.step.uno.model.Card;
import com.step.uno.model.Colour;
import com.step.uno.model.Game;
import com.step.uno.model.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class GameMasterTest {

    private CommunicationFactoryStub communicationFactoryStub = new CommunicationFactoryStub();
    private UnoFactoryStub unoFactoryStub = new UnoFactoryStub();
    private MessageChannel messageChannelMock = mock(MessageChannel.class);
    private GameMaster gameMaster;

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
    @Before
    public void setup(){
        gameMaster = new GameMaster(communicationFactoryStub, unoFactoryStub);

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
        gameMaster.start(3,1);
        verify(communicationFactoryStub.messageServer, times(1)).startListeningForConnections(gameMaster);
    }

    @Test
    public void on_new_connection_player_proxy_is_created_and_started_and_added() {
        gameMaster.start(3,1);
        gameMaster.onNewConnection(messageChannelMock);
        verify(unoFactoryStub.playerProxy, times(1)).start();
    }

    @Test
    public void after_specified_number_of_players_join_reject_connection() {
        gameMaster.start(1,1);
        gameMaster.onNewConnection(messageChannelMock);
        gameMaster.onNewConnection(messageChannelMock);
        verify(unoFactoryStub.playerProxy, times(1)).start();
        verify(messageChannelMock, times(1)).stop();
    }

    @Test
    public void starts_a_game_when_all_players_are_registered() {
        gameMaster.start(1,1);
        gameMaster.onNewConnection(messageChannelMock);
        gameMaster.onPlayerRegistered(mock(Player.class));
        verify(unoFactoryStub.game, times(1)).initialize();
    }

    @Test
    public void send_snapshot_to_all_players_when_game_started() {
        gameMaster.start(1,1);
        gameMaster.onNewConnection(messageChannelMock);
        gameMaster.onPlayerRegistered(mock(Player.class));
        verify(unoFactoryStub.playerProxy, times(1)).sendSnapshot(unoFactoryStub.game);
    }

    @Test
    public void draws_a_card_from_closed_pile() {
        gameMaster.start(1,1);
        Player playerMock = mock(Player.class);
        gameMaster.onPlayerRegistered(playerMock);
        gameMaster.onPlayerDrewCard(playerMock);
        verify(unoFactoryStub.game, times(1)).drawCard(playerMock);
    }

    @Test
    public void gameMaster_sends_game_result_to_all_players_if_any_players_wins() {
        gameMaster.start(1,1);
        Player playerMock = mock(Player.class);
        when(playerMock.hasWon()).thenReturn(true);
        gameMaster.onPlayerRegistered(playerMock);
        gameMaster.onPlayerPlayed(playerMock, mock(Card.class), Colour.Black);
        verify(unoFactoryStub.game, times(1)).populateResult();
    }

    @Test
    public void game_master_updates_log_when_player_plays_any_card() {
        gameMaster.start(1,1);
        Player playerMock = mock(Player.class);
        gameMaster.onPlayerRegistered(playerMock);
        gameMaster.onPlayerPlayed(playerMock, mock(Card.class), Colour.Black);
        verify(unoFactoryStub.game, times(1)).updateLogOnPlayerPlayed(any(Player.class), any(Card.class));
    }

    @Test
    public void game_master_updates_log_when_player_draws_a_card() {
        gameMaster.start(1,1);
        Player playerMock = mock(Player.class);
        gameMaster.onPlayerRegistered(playerMock);
        gameMaster.onPlayerDrewCard(playerMock);
        verify(unoFactoryStub.game, times(1)).updateLogOnPlayerDrewCard(any(Player.class), any(String.class));
    }

    @Test
    public void on_draw2_card_it_should_draw_two_cards_from_game_for_the_given_player() {
        gameMaster.start(1,1);
        Player playerMock = mock(Player.class);
        gameMaster.onPlayerRegistered(playerMock);
        gameMaster.onPlayerDrewTwoCard(playerMock);
        verify(unoFactoryStub.game, times(1)).drawTwoCard(playerMock);
    }

    @Test
    public void on_player_declared_uno_update_status_of_player() {
        gameMaster.start(1,1);
        Player playerMock = mock(Player.class);
        gameMaster.onPlayerRegistered(playerMock);
        gameMaster.onPlayerDeclaredUno(playerMock);
        verify(playerMock, times(1)).declaredUno();
    }

    @Test
    public void on_player_declared_uno_update_log_of_game() {
        gameMaster.start(1,1);
        Player playerMock = mock(Player.class);
        gameMaster.onPlayerRegistered(playerMock);
        gameMaster.onPlayerDeclaredUno(playerMock);
        verify(unoFactoryStub.game, times(1)).updateLogOnPlayerDeclaredUno(playerMock);
    }
}
