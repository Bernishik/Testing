package com.Bernish.view;

import com.Bernish.controller.*;

import java.util.Scanner;

public class MyView {
    private Controller controller;
    private int controllerSize;
    public static boolean CheatOn = false;
    private static final int cheatNum = 0;

    //    final Map controllerResult = controller.getDoor();
    public MyView() {
        start();
        while (true) {
            show();
            controller.chooseDoor();
        }

    }


    private void recountSize() {
        controllerSize = controller.getCountDoors();
    }

    private void show() {
        clear();
        CheatOn = controller.isCheatOn();
        recountSize();
        if (controllerSize <= 0) {
            controller.win();
        }
        int i = 0;
        for (; i < controllerSize; i++) {
            String str = "";
            if (CheatOn) {
                int doorPower = controller.getDoorPower(i);
                boolean isMonster = controller.isMonster(i);
                str = (isMonster ? "Монстер " : "Артефакт ") + "Cила = " + doorPower;
            }
            System.out.println(i + 1 + "." + " Двері " + (i + 1) + "    " + str);
        }
        System.out.println(cheatNum + "." + (CheatOn ? "Виключити чіти" : " Включити чіти"));
    }

    private void start() {
        Scanner menu = new Scanner(System.in);
        System.out.println(" Вітаю в моїй грі. Ви Герой комп'ютерної гри, що володіє силою в 25 балів,\n" +
                " знаходиться в круглій задниці світу, з якого ведуть 10 закритих дверей.\n" +
                " За кожними дверима героя чекає або магічний артефакт, що дарує силу ,\n" +
                " або коман з яким герою потрібно битися.\n" +
                " Удачі Коман лох\n");
        System.out.println("Бажаєте почати? y/n ");
        String answer = menu.next();
        clear();
        if (answer.equals("y")) {
            controller = new ControllerImpl();
            controller.start();
        } else {
            ControllerImpl.Exit();
        }
    }

    private void clear() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
}
