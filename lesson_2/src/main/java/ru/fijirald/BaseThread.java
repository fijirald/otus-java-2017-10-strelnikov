package ru.fijirald;

public class BaseThread extends Thread {

    public void run() {
        while (!CounterSemaphore.getInstance().stop()) {
            doSomething();
        }
    }

    protected void doSomething() {

    }
}
