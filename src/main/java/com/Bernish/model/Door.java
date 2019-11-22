package com.Bernish.model;

public class Door {
    private boolean type; // if true - it is a monster, else its a artifact
    private int power;

    public Door(boolean type, int power) {
        this.type = type;
        this.power = power;
    }

    public boolean getType() {
        return type;
    }

    public int getPower() {
        return power;
    }
}
