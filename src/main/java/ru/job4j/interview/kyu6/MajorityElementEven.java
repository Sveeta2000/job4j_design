package ru.job4j.interview.kyu6;

import java.util.HashMap;
import java.util.Map;

public class MajorityElementEven {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        int number = -1;
        if (!map.isEmpty()) {
            int maxCount = map.values().stream().max(Integer::compareTo).orElse(0);
            number = map.entrySet().stream()
                    .filter(e -> e.getValue() == maxCount)
                    .map(Map.Entry::getKey)
                    .min(Integer::compareTo).orElse(-1);
        }
        return number;
    }

    public int mostFrequentEven2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int number = Integer.MAX_VALUE;
        int maxCount = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                int val = map.get(num);
                if (val > maxCount || val == maxCount && num < number) {
                    number = num;
                    maxCount = val;
                }
            }
        }
        return maxCount == 0 ? -1 : number;
    }
}
