package com.step.uno.model;

public enum Sign{
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
    DrawTwo(20),
    WildDrawFour(50),
    Wild(50);
    public final int points;

    Sign(int v) {
        this.points = v;
    }
}
