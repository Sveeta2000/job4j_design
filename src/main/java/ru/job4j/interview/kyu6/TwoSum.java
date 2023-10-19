package ru.job4j.interview.kyu6;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numberAndIndex = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numberAndIndex.containsKey(target - numbers[i])) {
                return new int[] {numberAndIndex.get(target - numbers[i]), i};
            }
            numberAndIndex.put(numbers[i], i);
        }
        return new int[] {};
    }
}
