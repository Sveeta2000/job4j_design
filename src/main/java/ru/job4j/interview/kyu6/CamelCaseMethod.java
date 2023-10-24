package ru.job4j.interview.kyu6;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CamelCaseMethod {
    public static String camelCase(String str) {
        if (str.length() == 0) {
            return "";
        }
        return Arrays.stream(str.trim().split("\\s+"))
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(Collectors.joining());
    }

}
