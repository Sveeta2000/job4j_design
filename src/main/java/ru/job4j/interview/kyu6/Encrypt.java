package ru.job4j.interview.kyu6;

public class Encrypt {
    public static String encryptThis(String text) {
        if (text.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String word : text.split(" ")) {
            sb.append((int) word.charAt(0));
            if (word.length() > 1) {
                sb.append(swap(word), 1, word.length());
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private static String swap(String word) {
            String[] arr = word.split("");
            String temp = arr[1];
            arr[1] = arr[word.length() - 1];
            arr[word.length() - 1] = temp;
            return String.join("", arr);

    }
}
