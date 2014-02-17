package com.tw.uno.master;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UnoFactory {

    public ServerSocket createServerSocket() {
        try {
            return new ServerSocket(8080);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Client acceptPlayer(ServerSocket serverSocket) {
        Socket socket;
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Client(socket);
    }
}
