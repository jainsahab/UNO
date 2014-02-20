package com.step.uno.messages;

import java.io.Serializable;

public class Introduction implements Serializable{
    public String playerName;

    public static Introduction create(String playerName) {
        Introduction res = new Introduction();
        res.playerName = playerName;
        return res;
    }
}
