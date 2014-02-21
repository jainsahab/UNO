package com.step.uno.model;

import java.awt.*;
import java.io.Serializable;

public enum Colour implements Serializable {
    Red(Color.RED),
    Green(Color.GREEN),
    Blue(Color.BLUE),
    Yellow(Color.YELLOW),
    Black(Color.BLACK);
    private final Color color;

    Colour(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
