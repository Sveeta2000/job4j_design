package ru.job4j.interview.kyu6;

public class NumberExpandedForm {
    public static String expandedForm(int num) {
        int[] parts = new int[String.valueOf(num).length()];
        for (int i = 0; i < parts.length; i++) {
            parts[i] = num % 10;
            num /= 10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = parts.length - 1; i >= 0; i--) {
            if (parts[i] != 0) {
                stringBuilder.append(parts[i])
                        .append("0".repeat(i))
                        .append(" + ");
            }
        }
        return stringBuilder.substring(0, stringBuilder.length() - 3);
    }
}
