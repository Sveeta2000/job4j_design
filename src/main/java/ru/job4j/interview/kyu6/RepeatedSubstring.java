package ru.job4j.interview.kyu6;

public class RepeatedSubstring {
    public boolean repeatedSubstringPattern(String s) {
        StringBuilder dubbed = new StringBuilder(s.repeat(2))
                .deleteCharAt(0);
        dubbed.deleteCharAt(dubbed.length() - 1);
        return dubbed.toString().contains(s);
    }
}
