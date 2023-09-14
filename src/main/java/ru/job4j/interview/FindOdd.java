package ru.job4j.interview;

import java.util.HashMap;
import java.util.Map;

public class FindOdd {
    public static int findIt(int[] a) {
        if (a == null || a.length < 1) {
            throw new IllegalArgumentException("Array must contain at least one number");
        }
        Map<Integer, Integer> numbers = new HashMap<>();
        for (Integer number : a) {
            numbers.put(number, numbers.getOrDefault(number, 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }
}
