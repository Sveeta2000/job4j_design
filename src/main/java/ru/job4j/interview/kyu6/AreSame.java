package ru.job4j.interview.kyu6;

import java.util.Arrays;

public class AreSame {
    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length) {
            return false;
        }
        int[] sortedA = Arrays.stream(a).map(x -> x * x).sorted().toArray();
        int[] sortedB = Arrays.stream(b).sorted().toArray();
        return Arrays.equals(sortedA, sortedB);
    }
}
