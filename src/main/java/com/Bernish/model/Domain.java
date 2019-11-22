package com.Bernish.model;

import java.util.*;


public class Domain {
    private final int amount = 10; // кількість дверей
    private int heroPower = 25;
    public LinkedList<Door> door = new LinkedList<>();
    public boolean isCheatOn = false;

    private int getRandom(int max) {
        int result;
        Random random = new Random();
        result = random.nextInt(max);
        return result;
    }

    private int getRandom(int max, int min) {
        int result;
        int diff;
        Random random = new Random();
        diff = max - min;
        result = random.nextInt(diff + 1) + min;
        return result;
    }


    public int getHeroPower() {
        return heroPower;
    }

    public void setHeroPower(int heroPower) {
        this.heroPower = heroPower;
    }

    public void genDoor() {
        for (int i = 0; i < amount; i++) {
            boolean monster;
            int power;
            if (getRandom(10) > 5) {
                monster = true;
            } else {
                monster = false;
            }
            if (monster == true) {
                power = getRandom(100, 5);
            } else {
                power = getRandom(80, 10);
            }

            door.add(new Door(monster, power));
        }

    }

    public boolean isMonster(int i) {
        return door.get(i).getType();
    }

    public int doorPower(int i) {
        return door.get(i).getPower();
    }

    public int getCountDoors() {
        return door.size();
    }

}
