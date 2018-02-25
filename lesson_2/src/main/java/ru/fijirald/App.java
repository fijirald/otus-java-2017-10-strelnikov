package ru.fijirald;


public class App {

    String aaa = "dfasdfaasd";
    Integer d = 3;
    Double a = 2.2;
    Float f = 2323.2F;

    public static void main( String... args ) throws InterruptedException {
//        System.out.println("dfadsff");
        new InterferenceExample().start();
    }

    public App(String aaa, Integer d) {
        this.aaa = aaa;
        this.d = d;
    }
}
