package com.step.uno.server;

import com.step.communication.factory.CommunicationFactory;
import com.step.communication.server.MessageServer;
import com.step.uno.factory.Factory;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class GameMasterTest {
    private class CommunicationFactoryStub extends CommunicationFactory {
        public final MessageServer messageServer = mock(MessageServer.class);

        @Override
        public MessageServer createMessageServer() {
            return messageServer;
        }
    }

    @Test
    public void testToStartMethod() {
        CommunicationFactoryStub communicationFactoryStub = new CommunicationFactoryStub();
        GameMaster gameMaster = new GameMaster(2, 1, communicationFactoryStub);
        gameMaster.start();
        verify(communicationFactoryStub.messageServer, times(1)).startListeningForConnections(gameMaster);
    }
    @Test
    public void testShouldInitializeTheGame(){

    }
}
