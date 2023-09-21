package ru.job4j.interview;

public class DigitalRoot {
    public static int digitalRoot(int n) {
        int sum = recurse(n);
        while (sum / 10 > 0) {
            sum = recurse(sum);
        }
        return sum;
    }

    private static int recurse(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}
