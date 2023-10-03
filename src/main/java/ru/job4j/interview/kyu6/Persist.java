package ru.job4j.interview.kyu6;

public class Persist {
    public static int persistence(long n) {
        int count = 0;
        while (n >= 10) {
            int product = 1;
            while (n > 0) {
                product *= n % 10;
                n /= 10;
            }
            n = product;
            count++;
        }
        return count;
    }
}
