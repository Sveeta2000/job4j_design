package ru.job4j.interview.kyu6;

import java.util.Arrays;

public class SortOdd {
    public static int[] sortArray(int[] array) {
        int[] odds = Arrays.stream(array).filter(x -> x % 2 != 0).sorted().toArray();
        int oddIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                array[i] = odds[oddIndex];
                oddIndex++;
            }
        }
        return array;
    }
}
