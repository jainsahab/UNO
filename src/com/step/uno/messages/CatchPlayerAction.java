package com.step.uno.messages;

import java.io.Serializable;

public class CatchPlayerAction implements Serializable {
    public final String name;
    public final int playerIndex;

    public CatchPlayerAction(String name, int playerIndex) {
        this.name = name;
        this.playerIndex = playerIndex;
    }
}
