package ru.fijirald;

import java.util.concurrent.atomic.AtomicInteger;

public final class CountedThread extends BaseThread {
//    private volatile static int i;
    static StateObject obj = new StateObject();
//    private static AtomicInteger i = new AtomicInteger(0);

    protected void doSomething() {
//    protected void doSomething() {
        super.doSomething();

        obj.increment();

//        synchronized (CountedThread.class) {
//            i++;
//        }

//        i.incrementAndGet();
//        i.getAndDecrement();
    }

    public int getI() {
//        return i;
        return obj.getI();
    }

//    public AtomicInteger getI() {
//        return i;
//    }
}
