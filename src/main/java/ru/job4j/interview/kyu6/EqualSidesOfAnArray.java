package ru.job4j.interview.kyu6;

import java.util.Arrays;

public class EqualSidesOfAnArray {
    public static int findEvenIndex(int[] arr) {
        System.out.println(Arrays.toString(arr));
        if (arr.length == 1) {
            return 0;
        }
        int firstSum = Arrays.stream(arr).sum() - arr[0];
        int secondSum = 0;
        int temp = arr[0];
        int result = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (secondSum == firstSum) {
                result = i;
                break;
            }
            secondSum += temp;
            temp = arr[i + 1];
            firstSum -= temp;
            if (secondSum == firstSum) {
                result = i + 1;
            }
        }
        return result;
    }
}
