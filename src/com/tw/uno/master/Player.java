package com.tw.uno.master;

import com.tw.uno.view.Players;

import java.net.Socket;

public class Player extends Players {
    private Socket socket;

    public Player(Socket socket) {
        this.socket = socket;
    }
}
