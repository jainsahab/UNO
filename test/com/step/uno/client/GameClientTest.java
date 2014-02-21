package com.step.uno.client;

import com.step.communication.channel.MessageChannel;
import com.step.communication.channel.MessageChannelListener;
import com.step.communication.factory.CommunicationFactory;
import com.step.uno.messages.DrawCardAction;
import com.step.uno.messages.Introduction;
import com.step.uno.messages.Snapshot;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class GameClientTest {

    private CommunicationFactoryStub factoryStub = new CommunicationFactoryStub();
    private final GameClientObserver gameClientObserverMock = mock(GameClientObserver.class);
    private GameClient gameClient = new GameClient(factoryStub);


    public class CommunicationFactoryStub extends CommunicationFactory {

        public final MessageChannel messageChannel = mock(MessageChannel.class);

        @Override
        public MessageChannel connectTo(String serverAddress, MessageChannelListener observer) {
            return messageChannel;
        }

    }

    @Test
    public void starting_client_starts_listening_for_messages() {
        gameClient.start("me", "serverAddress", gameClientObserverMock);
        verify(factoryStub.messageChannel, times(1)).startListeningForMessages(gameClient);
    }

    @Test
    public void starting_connection_client_sends_player_introduction() {
        gameClient.start("me", "serverAddress", gameClientObserverMock);
        verify(factoryStub.messageChannel, times(1)).send(any(Introduction.class));
    }

    @Test
    public void on_message_with_snapshot_client_should_call_update_of_observer() {
        Snapshot snapshot = new Snapshot();
        gameClient.start("me", "serverAddress", gameClientObserverMock);
        gameClient.onMessage(factoryStub.messageChannel, snapshot);
        verify(gameClientObserverMock, times(1)).update(snapshot);
    }

    @Test
    public void on_draw_card_client_sends_message_on_channel() {
        gameClient.start("me", "serverAddress", gameClientObserverMock);
        gameClient.draw();
        verify(factoryStub.messageChannel, times(2)).send(any(DrawCardAction.class));
    }

}
