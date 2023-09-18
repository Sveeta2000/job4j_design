package ru.job4j.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CreateTwoSetsOfEqualSum {
    public static List<List<Integer>> createTwoSetsOfEqualSum(int n) {
        final List<List<Integer>> sets = new ArrayList<>();
        if (IntStream.range(1, n + 1).sum() % 2 != 0) {
            sets.add(new ArrayList<>());
            sets.add(new ArrayList<>());
            return sets;
        }
        long sum1 = n;
        long sum2 = 0;
        List<Integer> list1 = new ArrayList<>();
        list1.add(n);
        List<Integer> list2 = new ArrayList<>();
        for (int i = n - 1; i > 0; i--) {
            if (sum1 > sum2) {
                sum2 += i;
                list2.add(i);
            } else {
                sum1 += i;
                list1.add(i);
            }
        }
        sets.add(list1);
        sets.add(list2);
        return sets;
    }
}
