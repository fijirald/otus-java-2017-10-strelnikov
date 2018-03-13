package ru.fijirald;


import java.util.*;

public class App {

    static StateObject stateObject = new StateObject();

    public static void main( String... args ) throws InterruptedException, Exception {

        int[] unsortedArray = new Random().ints(30, 0, 50).toArray();
        System.out.println("original array = " + Arrays.toString(unsortedArray));
        System.out.println();

        parallelSort(unsortedArray, 4);

        System.out.println("\nsortedArray = " + Arrays.toString(stateObject.getSortedArray()));
    }


    public static List<? extends Number> parallelSort(int[] arr, int streamCount) throws Exception {

        if(streamCount < 1) {
            throw new Exception("streamCount must be more than 0");
        }
        if(arr == null || arr.length == 0) {
            throw new Exception("list must be initialized and not empty");
        }

        List<Map<String, Integer>> indexMap = getIndexMap(arr.length, streamCount);

        List<Thread> threadPool = new ArrayList<>(streamCount);

        getIndexMap(arr.length, streamCount).forEach((map) -> {
            Thread thread = new Thread(() -> {
                int[] part = Arrays.copyOfRange(arr, map.get("fromIndex"), map.get("toIndex"));
                Arrays.sort(part);
                stateObject.mergeWithCommonArray(part);
            });

            thread.start();
            System.out.println("Запущен поток: " + thread.getName());
            threadPool.add(thread);
        });

        System.out.println("Делаем join по очереди к каждому нашему потоку, чтобы удостовериться, что все наши потоки сделали сортировку и слияние между собой и мы можем вывести конечный результат");
        threadPool.forEach((thread) -> {
            try {
                thread.join();
                System.out.println("join for: " + thread.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        return null;
    }

    private static List<Map<String, Integer>> getIndexMap(int listSize, int streamCount) {

        int step = (listSize / streamCount) + 1;

        List<Map<String, Integer>> result = new ArrayList<>();

        int fromIndex = 0;
        int toIndex = 0;

        while (toIndex + step < listSize) {
            toIndex += step;

            Map<String, Integer> indexMap = new HashMap<>();
            indexMap.put("fromIndex", fromIndex);
            indexMap.put("toIndex", toIndex);

            result.add(indexMap);

            fromIndex = toIndex;
        }

        Map<String, Integer> indexMap = new HashMap<>();
        indexMap.put("fromIndex", fromIndex);
        indexMap.put("toIndex", listSize);

        result.add(indexMap);

        return result;
    }

}
