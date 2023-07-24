package ru.job4j.interview;

import java.util.HashSet;
import java.util.Set;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        Set<Character> duplicates = new HashSet<>();
        Set<Character> seen = new HashSet<>();
        for (char c : text.toLowerCase().toCharArray()) {
            if (seen.contains(c)) {
                duplicates.add(c);
            } else {
                seen.add(c);
            }
        }
        return duplicates.size();
    }
}
