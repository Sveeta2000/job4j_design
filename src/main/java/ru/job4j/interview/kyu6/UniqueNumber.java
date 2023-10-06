package ru.job4j.interview.kyu6;

import java.util.Arrays;

public class UniqueNumber {
    public static double findUnique(double[] arr) {
        return Arrays.stream(arr).distinct()
                .filter(x -> (x != arr[0] && x != arr[1]) || (x != arr[0] && x != arr[2])
                        || (x != arr[1] && x != arr[2]))
                .findFirst().orElse(0.00);
    }
}
