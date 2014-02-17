package com.tw.uno.master;

import org.junit.Test;

import java.net.ServerSocket;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MasterServerTest {

    private UnoFactory unoFactory = mock(UnoFactory.class);

    @Test
    public void startingServerCreatesServerSocket() {
        MasterServer server = new MasterServer(2,1, unoFactory);
        server.start();

        verify(unoFactory,times(1)).createServerSocket();
    }

    @Test
    public void startingserverAcceptsNumberOfPlayers() {
        MasterServer server = new MasterServer(10,1,unoFactory);
        server.start();

        verify(unoFactory,times(10)).acceptPlayer(any(ServerSocket.class));
    }
}
