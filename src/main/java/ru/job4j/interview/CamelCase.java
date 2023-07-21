package ru.job4j.interview;

public class CamelCase {

    static String toCamelCase(String s) {
        StringBuilder rsl = new StringBuilder();
        String[] words = s.split("[-_]");
        rsl.append(words[0]);
        String firstLetter;
        String word;
        for (int i = 1; i < words.length; i++) {
            String temp = words[i];
            firstLetter = temp.substring(0, 1);
            word = temp.substring(1);
            rsl.append(firstLetter.toUpperCase()).append(word);
        }
        return rsl.toString();
    }
}
