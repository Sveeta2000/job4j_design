package ru.job4j.interview.kyu6;

import java.util.Arrays;

public class SumParts {
    public static int[] sumParts(int[] ls) {
        int sum = Arrays.stream(ls).sum();
        int[] result = new int[ls.length + 1];
        result[0] = sum;
        for (int i = 0; i < ls.length; i++) {
            sum -= ls[i];
            result[i + 1] = sum;
        }
        return result;
    }
}
