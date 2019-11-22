package com.Bernish.model;


public interface Model {

    void fight(int i);

    void findArtifacts(int i);

    void gameOver();

    void win();

    void openDoor(int i);

    int getCountDoors();

    //cheats
    int getDoorPower(int i);

    boolean isMonster(int i);

    boolean isCheatOn();

    void setCheat();
}
