package ru.job4j.interview.kyu5;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int left = 0;
        int right = 0;
        int sLength = s.length();
        Map<Character, Integer> map = new HashMap<>();
        while (right < sLength) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(map.get(c) + 1, left);
            }
            map.put(c, right);
            length = Math.max(length, right - left + 1);
            right++;
        }
        return length;
    }
}
