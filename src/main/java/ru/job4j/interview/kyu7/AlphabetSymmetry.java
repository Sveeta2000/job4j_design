package ru.job4j.interview.kyu7;

public class AlphabetSymmetry {

    public static int[] solve(String[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            int symmetriCount = 0;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (Character.toUpperCase(c) - 'A' == j) {
                    symmetriCount++;
                }
            }
            result[i] = symmetriCount;
        }
        return result;
    }
}
