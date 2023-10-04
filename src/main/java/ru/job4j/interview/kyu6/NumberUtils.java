package ru.job4j.interview.kyu6;

public class NumberUtils {
    public static boolean isNarcissistic(int number) {
        int power = String.valueOf(number).length();
        long sum = 0;
        int n = number;
        while (n > 0) {
            sum += Math.pow(n % 10, power);
            n /= 10;
        }
        return sum == number;
    }
}
