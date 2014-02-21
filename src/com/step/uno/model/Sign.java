package com.step.uno.model;

import java.io.Serializable;

public enum Sign implements Serializable {
    _0(0),
    _1(1),
    _2(2),
    _3(3),
    _4(4),
    _5(5),
    _6(6),
    _7(7),
    _8(8),
    _9(9),
    Reverse(20),
    Skip(20),
    Draw2(20),
    Draw4(50),
    Wild(50);
    public final int points;

    Sign(int v) {
        this.points = v;
    }
}