package com.Bernish.controller;

import com.Bernish.model.*;

import java.util.Scanner;


public class ControllerImpl implements Controller {
    private Model model;

    public ControllerImpl() {
        this.start();
    }

    public void start() {
        model = new GameLogic();

    }

    public static void Exit() {
        GameLogic.Exit();
    }

    public int getCountDoors() {
        return ((GameLogic) model).getCountDoors();
    }

    public int getDoorPower(int i) {
        return model.getDoorPower(i);
    }

    @Override
    public boolean isMonster(int i) {
        return model.isMonster(i);
    }

    @Override
    public void win() {
        model.win();
    }

    @Override
    public boolean isCheatOn() {
        return model.isCheatOn();
    }

    @Override
    public void chooseDoor() {
        int chosenDoor;
        Scanner door = new Scanner(System.in);
        chosenDoor = door.nextInt();
        if (chosenDoor < model.getCountDoors() + 1 && chosenDoor > 0) {
            model.openDoor(chosenDoor - 1);
        } else if (chosenDoor == 0) {
            model.setCheat();
        } else {
            System.out.println("Упс. Такої дверки не існує");
        }

    }


}
