package ru.job4j.interview;

import java.util.Arrays;

public class FindOutlier {
    static int find(int[] integers) {
        if (isOdd(integers)) {
            return Arrays.stream(integers).filter(x -> x % 2 == 0).findFirst().orElse(0);
        } else {
            return Arrays.stream(integers).filter(x -> x % 2 != 0).findFirst().orElse(0);
        }
    }

    private static boolean isOdd(int[] ints) {
        return ((ints[0] % 2 != 0) && (ints[1] % 2 != 0))
                || ((ints[1] % 2 != 0) && (ints[2] % 2 != 0))
                || ((ints[0] % 2 != 0) && (ints[2] % 2 != 0));
    }
}
