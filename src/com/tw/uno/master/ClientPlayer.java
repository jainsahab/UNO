package com.tw.uno.master;

import java.util.ArrayList;
import java.util.List;

public class ClientPlayer {
    private String name;
    private int number_of_cards;
    private List<Card> cards = new ArrayList<>();

    public ClientPlayer(String playerName) {
        this.name = playerName;
    }
}
