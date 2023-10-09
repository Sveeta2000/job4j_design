package ru.job4j.interview.kyu6;

import java.util.List;

public class SmileFaces {
    public static int countSmileys(List<String> arr) {
        int count = 0;
        for (String s : arr) {
            if (s.matches("[;:][-~]?[)D]")) {
                count++;
            }
        }
        return count;
    }
}
