package ru.job4j.interview.kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumGroups {
    public static int sumGroups(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        List<Integer> result = new ArrayList<>(list.size());
        boolean wasChanged = true;
        while (wasChanged) {
            int length = list.size();
            int index = 0;
            wasChanged = false;
            result.add(list.get(0));
            for (int i = 0; i < length - 1; i++) {
                if ((list.get(i) % 2) == (list.get(i + 1) % 2)) {
                    result.set(index, result.get(index) + list.get(i + 1));
                    wasChanged = true;
                } else {
                    index++;
                    result.add(list.get(i + 1));
                }
            }
            list = result;
            result = new ArrayList<>();
        }
        return list.size();
    }
}
