package ru.job4j.interview.kyu6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateEncoder {
    static String encode(String word) {
        word = word.toLowerCase();
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            count.put(String.valueOf(word.charAt(i)), count.getOrDefault(String.valueOf(word.charAt(i)), 0) + 1);
        }
        return Arrays.stream(word.split(""))
                .map(x -> count.get(x) > 1 ? ")" : "(")
                .collect(Collectors.joining());
    }
}
