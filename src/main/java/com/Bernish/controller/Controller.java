package com.Bernish.controller;


public interface Controller {
    void start();

    void chooseDoor();

    int getCountDoors();

    void win();

    // cheats
    int getDoorPower(int i);

    boolean isMonster(int i);

    boolean isCheatOn();
}
