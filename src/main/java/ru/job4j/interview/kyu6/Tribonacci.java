package ru.job4j.interview.kyu6;

public class Tribonacci {
    public static double[] tribonacci(double[] s, int n) {
        if (s == null || s.length < 3 || n == 0) {
            return new double[0];
        }
        double[] result = new double[n];
        if (n <= 3) {
            System.arraycopy(s, 0, result, 0, n);
            return result;
        }
        System.arraycopy(s, 0, result, 0, 3);
        for (int i = 3; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2] + result[i - 3];
        }
        return result;
    }
}
