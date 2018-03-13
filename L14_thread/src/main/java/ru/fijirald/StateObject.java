package ru.fijirald;

import java.util.Arrays;

public class StateObject {

    private int[] sortedArray;

    public synchronized void mergeWithCommonArray(int[] b) {
        System.out.println("start merging of array: = " + Arrays.toString(b));
        if(sortedArray != null) {
            int[] answer = new int[sortedArray.length + b.length];
            int i = sortedArray.length - 1, j = b.length - 1, k = answer.length;

            while (k > 0)
                answer[--k] =
                        (j < 0 || (i >= 0 && sortedArray[i] >= b[j])) ? sortedArray[i--] : b[j--];

            sortedArray = answer;
        } else {
            sortedArray = b;
        }
    }


    public int[] getSortedArray() {
        return sortedArray;
    }
}
