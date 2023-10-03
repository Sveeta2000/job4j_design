package ru.job4j.interview.kyu5;

public class PigLatin {
    public static String pigIt(String str) {
        StringBuilder result = new StringBuilder();
        String[] words = str.split(" ");
        for (String word : words) {
            if (word.matches("\\w+")) {
                result.append(word.substring(1)).append(word.charAt(0)).append("ay ");
            } else {
                result.append(word);
            }
        }
        return result.toString().trim();
    }
}
