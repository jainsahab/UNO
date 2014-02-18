package com.tw.uno.master;

import java.io.Serializable;

public class Message implements Serializable{
    public String status;
    public String playerName;
    public ServerPlayer newPlayer;

    public Message(String status) {
        this.status = status;
    }

    public Message(String status, String playerName) {
        this.status = status;
        this.playerName = playerName;
    }

    public String getStatus() {
        return status;
    }
}
