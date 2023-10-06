package ru.job4j.interview.kyu5;

public class MaxSubarraySum {
    public static int sequence(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int j : arr) {
            sum += j;
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return Math.max(max, 0);
    }
}
