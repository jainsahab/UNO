package com.step.uno.model;

import java.awt.*;
import java.io.Serializable;

public enum Colour implements Serializable {
    Red(Color.decode("#DB1C07")),
    Green(Color.decode("#50DE37")),
    Blue(Color.decode("#324AD1")),
    Yellow(Color.decode("#F2EF16")),
    Black(Color.decode("#080801"));
    private final Color color;

    Colour(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
