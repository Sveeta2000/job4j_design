package ru.job4j.interview.kyu6;

public class DigPow {
    public static long digPow(int n, int p) {
        long sum = 0;
        String number = String.valueOf(n);
        int temp = n;
        p += number.length() - 1;
        while (temp > 0) {
            sum += Math.pow(temp % 10, p);
            temp /= 10;
            p--;
        }
        return sum % n == 0 ? sum / n : -1;
    }
}
