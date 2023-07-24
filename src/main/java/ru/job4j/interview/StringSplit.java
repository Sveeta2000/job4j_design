package ru.job4j.interview;

public class StringSplit {
    public static String[] solution(String s) {
        int l = s.length() % 2 + s.length() / 2;
        String[] result = new String[l];
        int index = 0;
        while (s.length() > 0) {
            if (s.length() == 1) {
                result[index] = s + "_";
                break;
            }
            result[index++] = s.substring(0, 2);
            s = s.substring(2);
        }
        return result;
    }
}
