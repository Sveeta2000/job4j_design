package ru.job4j.interview;

public class TrailingZeros {
    public static int zeros(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
