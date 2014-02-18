package com.tw.uno.master;

import java.io.Serializable;
import java.util.HashMap;

public class Message implements Serializable{
    String status;
    String playerName;
    public HashMap<String, ServerPlayer> players;

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
