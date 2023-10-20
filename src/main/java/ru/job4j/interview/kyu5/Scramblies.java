package ru.job4j.interview.kyu5;

import java.util.HashMap;
import java.util.Map;

public class Scramblies {
    public static boolean scramble(String str1, String str2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : str1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : str2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            try {
                if (map1.get(entry.getKey()) < entry.getValue()) {
                    return false;
                }
            } catch (NullPointerException e) {
                return false;
            }
        }
        return true;
    }
}
