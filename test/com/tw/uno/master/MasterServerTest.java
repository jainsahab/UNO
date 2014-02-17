package com.tw.uno.master;

import org.junit.Test;

import java.net.ServerSocket;
import java.net.Socket;

import static org.mockito.Mockito.*;

public class MasterServerTest {

    public class UnoFactoryStub extends UnoFactory {
        public ServerSocket serverSocket = mock(ServerSocket.class);
        public MessageChannel channel = mock(MessageChannel.class);
        public Socket socket = mock(Socket.class);

        public ServerSocket createServerSocket() {
            return serverSocket;
        }

        public MessageChannel acceptPlayerSocket(ServerSocket serverSocket) {
            return channel;
        }

        public Player createPlayer(MessageChannel messageChannel, String name) {
            return new Player(messageChannel, name);
        }
    }

    ;

    @Test
    public void startingServerAcceptsNumberOfPlayers() {
        UnoFactoryStub unoFactory = new UnoFactoryStub();
        MasterServer server = new MasterServer(10, 1, unoFactory);
        server.start();

        verify(unoFactory.channel, times(10)).startListeningForMessages(any(MessageChannelListener.class));
    }
}
