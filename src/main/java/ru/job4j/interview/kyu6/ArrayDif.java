package ru.job4j.interview.kyu6;

import java.util.Arrays;
import java.util.List;

public class ArrayDif {
    public static int[] arrayDiff(int[] a, int[] b) {
        List<Integer> bList = Arrays.stream(b).boxed().toList();
        return Arrays.stream(a).filter(x -> !bList.contains(x)).toArray();
    }
}
