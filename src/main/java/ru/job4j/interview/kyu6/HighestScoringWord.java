package ru.job4j.interview.kyu6;

import java.util.ArrayList;
import java.util.List;

public class HighestScoringWord {
    public static String high(String s) {
        String[] strings = s.split(" ");
        List<Integer> scores = new ArrayList<>(strings.length);
        for (String string : strings) {
            scores.add(string.chars().map(x -> x - 'a' + 1).sum());
        }
        int highest = scores.indexOf(scores.stream().mapToInt(v -> v).max().orElse(0));
        return strings[highest];
    }
}
