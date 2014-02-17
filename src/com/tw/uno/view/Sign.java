package com.tw.uno.view;


public enum Sign {
    ZERO("0"), ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9");
    String cardValue;
    Sign(String value) {
        cardValue = value;
    }

    @Override
    public String toString() {
        return cardValue;
    }
}
