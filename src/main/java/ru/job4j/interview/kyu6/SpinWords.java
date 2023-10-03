package ru.job4j.interview.kyu6;

import java.util.Arrays;

public class SpinWords {
    private StringBuilder result = new StringBuilder();

    public String spinWords(String sentence) {
        String[] words = sentence.split(" ");
        Arrays.stream(words).forEach(this::reverse);
        return result.toString().trim();
    }

    private void reverse(String str) {
        if (str.length() < 5) {
            result.append(str);
        } else {
            StringBuilder sb = new StringBuilder(str);
            result.append(sb.reverse());
        }
        result.append(" ");
    }
}
