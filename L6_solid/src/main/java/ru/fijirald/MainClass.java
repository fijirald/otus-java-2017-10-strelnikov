package ru.fijirald;

import ru.fijirald.menu.Menu;
import ru.fijirald.menu.MenuItem;

public class MainClass {

    public static void depositMoney() {
        System.out.println(">deposit money");
    }

    public static void getMoney() {
        System.out.println(">get money");
    }

    public static Menu getMenu() throws Exception {
        Menu menu = new Menu();
        menu.addItem(new MenuItem("1","Внести средства", () -> depositMoney()));
        menu.addItem(new MenuItem("2","Снять средства", () -> getMoney()));

        return menu;
    }


    public static void main(String[] args) throws Exception {

        Menu menu = getMenu();
        menu.run();
    }
}
