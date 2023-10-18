package ru.job4j.interview.kyu6;

import java.util.Arrays;

public class SupermarketQueue {
    public static int solveSuperMarketQueue(int[] customers, int n) {
        if (customers.length == 0 || n == 0) {
            return 0;
        }
        int[] tills = new int[n];
        for (int i = 0; i < n && i < customers.length; i++) {
            tills[i] = customers[i];
        }
        for (int i = n; i < customers.length; i++) {
            int index = minIndex(tills);
            tills[index] += customers[i];
        }
        return Arrays.stream(tills).max().orElse(0);
    }

    private static int minIndex(int[] arr) {
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[index]) {
                index = i;
            }
        }
        return index;
    }
}
