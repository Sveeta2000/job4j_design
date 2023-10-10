package ru.job4j.interview.kyu6;

import java.util.*;

public class EnoughIsEnough {
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int element : elements) {
            count.put(element, count.getOrDefault(element, 0) + 1);
            if (count.get(element) <= maxOccurrences) {
                result.add(element);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
