package com.tw.uno.master;

import java.io.Serializable;

public class ServerPlayer implements Serializable {
    private String name;
    private int totalCards;

    public ServerPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getTotalCards() {
        return totalCards;
    }

    public void setTotalCards(int totalCards) {
        this.totalCards = totalCards;
    }
}
