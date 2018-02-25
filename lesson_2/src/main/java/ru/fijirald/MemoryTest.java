package ru.fijirald;

import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class MemoryTest {

    public static final int SIZE = 100_000;

    public static void main(String[] args) {
        printUsage(String::new, "Empty String");
        printUsage(Object::new, "Empty Object");
//        printUsage(App::new, "Empty App");
    }

    private static <T> Object printUsage(@NotNull Supplier<T> supplier, @NotNull String comment) {
        final Object[] objs = new Object[SIZE];
        Runtime runtime = Runtime.getRuntime();

        runtime.gc();

        long memBefore = runtime.totalMemory() - runtime.freeMemory();
        for(int i = 0; i< SIZE; i++) {
            objs[i] = supplier.get();
        }

        runtime.gc();
        long memAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(String.format("\n%-30s\tSIZEOF(): %d bytes\n", comment, Math.round((double) (memAfter - memBefore) / SIZE)));

        return objs;
    }
}
