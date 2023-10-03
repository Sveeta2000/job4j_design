package ru.job4j.interview.kyu6;

public class Order {
    public static String order(String words) {
        if (words == null || words.length() == 0) {
            return "";
        }
        String[] array = words.split(" ");
        String[] ordered = new String[array.length];
        for (String s : array) {
            int num = Integer.parseInt(s.replaceAll("\\D", ""));
            ordered[num - 1] = s;
        }
        return String.join(" ", ordered);
    }
}
