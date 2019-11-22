package com.Bernish.model;

import java.util.LinkedList;

public class GameLogic implements Model {
    private Domain domain;

    public GameLogic() {
        domain = new Domain();
        domain.genDoor();
    }

    public int getHeroPower() {
        return domain.getHeroPower();
    }

    public int getDoorPower(int i) {
        return domain.doorPower(i);
    }

    @Override
    public void setCheat() {
        domain.isCheatOn = !domain.isCheatOn;
    }

    @Override
    public boolean isCheatOn() {
        return domain.isCheatOn;
    }

    @Override
    public boolean isMonster(int i) {
        return domain.isMonster(i);
    }

    public int getCountDoors() {
        return domain.getCountDoors();
    }

    public static void Exit() {
        System.exit(2);
    }

    ;

    @Override
    public void openDoor(int i) {
        boolean isMonster = domain.isMonster(i);
        if (isMonster) {
            fight(i);
        } else {
            findArtifacts(i);
        }
    }


    @Override
    public void fight(int i) {
        if (domain.doorPower(i) <= domain.getHeroPower()) {
            domain.door.remove(i);
            System.out.println("Ви вбили монстра!");
        } else {
            gameOver();
        }

    }

    @Override
    public void findArtifacts(int i) {
        int upp = domain.doorPower(i);
        domain.setHeroPower(domain.getHeroPower() + upp);
        domain.door.remove(i);
        System.out.println("Ви знайшли артефакт. Ваша сила збільшилась на " + upp + " . І зараз дорівнює " + domain.getHeroPower());
        if (domain.getHeroPower() >= 100) {
            System.out.println("Ваша сила більша або дорівнює 100");
            win();
        }
    }

    @Override
    public void gameOver() {
        System.out.println("Ігра завершена. Ви програли!");
        Exit();
//        ControllerImpl.Exit();
    }

    @Override
    public void win() {
        System.out.println("Вітаю ви перемогли!");
        Exit();
    }
}
