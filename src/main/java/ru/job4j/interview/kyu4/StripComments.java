package ru.job4j.interview.kyu4;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StripComments {
    public static String stripComments(String text, String[] commentSymbols) {
        String[] lines = text.split("\n");
        String regex = " *[" + Arrays.stream(commentSymbols)
                .map(s -> "(" + s + ")")
                .collect(Collectors.joining())
                + "]" + ".*";
        regex = regex.replaceAll("-", "\\\\-");
        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].replaceAll(regex, "").stripTrailing();
        }
        return String.join("\n", lines);
    }
}
