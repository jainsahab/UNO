package com.step.uno.client;

public class ClientPlayer {
    public final String name;
    public final String totalCards;
    public final int playerIndex;
    public boolean declaredUno;
    public ClientPlayer(String name, String totalCards, int playerIndex,boolean declaredUno) {
        this.name = name;
        this.totalCards = totalCards;
        this.playerIndex = playerIndex;
        this.declaredUno = declaredUno;
    }
}
