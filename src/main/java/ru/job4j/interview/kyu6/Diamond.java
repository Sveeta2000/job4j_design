package ru.job4j.interview.kyu6;

public class Diamond {
    public static String print(int n) {
        if (n % 2 == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int stars = 1;
        for (int i = 0; i < n; i++) {
            sb.append(" ".repeat((n - stars) / 2));
            sb.append("*".repeat(stars));
            sb.append("\n");
            if (i < n / 2) {
                stars += 2;
            } else {
                stars -= 2;
            }
        }
        return sb.toString();
    }
}
