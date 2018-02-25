package ru.fijirald;

import java.util.concurrent.atomic.AtomicInteger;

class CounterSemaphore {

    static final int HUNDRED_MILLION = 100_000_000;

    private final AtomicInteger count = new AtomicInteger();
    private final static CounterSemaphore instance = new CounterSemaphore();

    public CounterSemaphore() {}

    public static CounterSemaphore getInstance() {
        return instance;
    }

    boolean stop() {
        return count.incrementAndGet() > HUNDRED_MILLION;
    }
}
