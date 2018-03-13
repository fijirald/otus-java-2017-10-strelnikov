package ru.fijirald.menu;

public class MenuItem {

    private String title;
    private String code;
    private MenuAction action;

    public MenuItem(String code, String title, MenuAction action){
        this.code = code;
        this.title = title;
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public MenuAction getAction() {
        return action;
    }
}
