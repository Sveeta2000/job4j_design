package ru.job4j.interview.kyu6;

import java.util.Arrays;
import java.util.Comparator;

public class CommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = Arrays.stream(strs).min(Comparator.comparingInt(String::length)).orElse("");
        for (String str : strs) {
            if (!str.startsWith(prefix)) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < prefix.length(); i++) {
                    if (prefix.charAt(i) == str.charAt(i)) {
                        sb.append(prefix.charAt(i));
                    } else {
                        break;
                    }
                }
                prefix = sb.toString();
            }
            if (prefix.equals("")) {
                break;
            }
        }
        return prefix;
    }
}
