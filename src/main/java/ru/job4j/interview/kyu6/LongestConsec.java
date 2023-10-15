package ru.job4j.interview.kyu6;

public class LongestConsec {
    public static String longestConsec(String[] strarr, int k) {
        if (k > strarr.length || k <= 0) {
            return "";
        }
        int startIndex = 0;
        int maxLength = 0;
        for (int i = 0; i <= strarr.length - k; i++) {
            int l = 0;
            for (int j = 0; j < k; j++) {
                l += strarr[i + j].length();
            }
            if (l > maxLength) {
                startIndex = i;
                maxLength = l;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = startIndex; i < startIndex + k; i++) {
            result.append(strarr[i]);
        }
        return result.toString();
    }
}
