package com.tw.uno.master;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class UnoFactory {

    public ServerSocket createServerSocket() {
        try {
            return new ServerSocket(8080);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public MessageChannel acceptPlayerSocket(ServerSocket serverSocket) {
        try {
            Socket socket = serverSocket.accept();
            socket.setSoTimeout(100);
            return new MessageChannel(socket);
        }
        catch (SocketTimeoutException ste){
            return null;
        }
        catch (IOException e) {
            throw new RuntimeException("could not accept connection",e);
        }
    }

    public Player createPlayer(MessageChannel messageChannel, String name) {
        return new Player(messageChannel,name);
    }
}
