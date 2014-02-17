package com.tw.uno.master;

public class Player {
    private MessageChannel messageChannel;
    private String name;

    public Player(MessageChannel messageChannel, String name) {
        this.messageChannel = messageChannel;
        this.name = name;
    }
}