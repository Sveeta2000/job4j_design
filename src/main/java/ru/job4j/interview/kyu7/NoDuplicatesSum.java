package ru.job4j.interview.kyu7;

import java.util.*;

public class NoDuplicatesSum {

    public static int sumNoDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int j : arr) {
            if (!set.contains(j) && !duplicates.contains(j)) {
                set.add(j);
            } else {
                set.remove(j);
                duplicates.add(j);
            }
        }
        return set.stream().reduce(Integer::sum).orElse(0);
    }

    public static void main(String[] args) {
        int s = NoDuplicatesSum.sumNoDuplicates(new int[]{5, 6, 10, 3, 10, 10, 6, 7, 0, 9, 1, 1, 6, 3, 1});
        System.out.println(s);
    }
}
