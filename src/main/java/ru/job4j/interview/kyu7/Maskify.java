package ru.job4j.interview.kyu7;

public class Maskify {

    public static String maskify(String str) {
        StringBuilder result = new StringBuilder();
        if (str.length() > 4) {
            result.append("#".repeat(str.length() - 4));
            result.append(str.substring(str.length() - 4));
        } else {
            result.append(str);
        }
        return result.toString();
    }
}
