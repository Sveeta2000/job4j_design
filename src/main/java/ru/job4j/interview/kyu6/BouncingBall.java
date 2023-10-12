package ru.job4j.interview.kyu6;

public class BouncingBall {
    public static int bouncingBall(double h, double bounce, double window) {
        if (h <= 0 || bounce <= 0 || bounce >= 1 || window >= h) {
            return -1;
        }
        int count = 1;
        while (h > window) {
            h *= bounce;
            if (h > window) {
                count += 2;
            }

        }
        return count;
    }
}
