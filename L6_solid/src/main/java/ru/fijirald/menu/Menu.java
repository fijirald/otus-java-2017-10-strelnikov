package ru.fijirald.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private String stringView = null;

    private MenuItem exitItem;
    private List<MenuItem> itemList = new ArrayList<>();

    {
        exitItem = new MenuItem("0","Завершить работу", () -> exit());
    }

    public void addItem(MenuItem item) throws Exception {
        validItem(item);
        itemList.add(item);
    }

    public void setExitItem(MenuItem item) throws Exception {
        validItem(item);
        this.exitItem = item;
    }

    public void init() {

        stringView = "-----------\n";
        stringView += "Меню:\n";

        for(MenuItem item: itemList) {
            stringView += String.format("%s - %s\n", item.getCode(), item.getTitle());
        }
        stringView += String.format("%s - %s\n", exitItem.getCode(), exitItem.getTitle());
        stringView += "Введите код действия и нажмите Enter:";
    }

    @Override
    public String toString() {
        if(stringView == null) this.init();

        return stringView;
    }

    private void exit() {
        System.out.println(">Работа окончена.");
    }

    private void validItem(MenuItem item) throws Exception {
        if(item.getCode() == null) {
            throw new Exception("Не задан код пункта меню");
        }
        if(item.getTitle() == null) {
            throw new Exception("Не задан заголовок пункта меню");
        }
        if(item.getAction() == null) {
            throw new Exception("Не задано действие пункта меню");
        }
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(this);

            String input = scanner.nextLine();

            if(exitItem.getCode().equals(input)) {
                exitItem.getAction().execute();
                break;
            }

            MenuAction chosenAction = null;

            for(MenuItem item: itemList) {
                if(item.getCode().equals(input)) {
                    chosenAction = item.getAction();
                    break;
                }
            }

            if(chosenAction != null) {
                chosenAction.execute();
            } else {
                System.out.println(">Нет такого действия, повторите ваш выбор");
            }
        }

        scanner.close();
    }
}
