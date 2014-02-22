package com.step.uno.model;

import java.io.Serializable;

public class PlayerSummary implements Serializable {
    public String name;
    public int cardsInHand;
    private boolean declaredUno;

    public PlayerSummary(String name, int cardsInHand, boolean declaredUno) {
        this.name = name;
        this.cardsInHand = cardsInHand;
        this.declaredUno = declaredUno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayerSummary summary = (PlayerSummary) o;

        if (cardsInHand != summary.cardsInHand) return false;
        if (declaredUno != summary.declaredUno) return false;
        if (!name.equals(summary.name)) return false;

        return true;
    }
}
