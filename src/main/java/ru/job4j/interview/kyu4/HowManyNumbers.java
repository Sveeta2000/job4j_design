package ru.job4j.interview.kyu4;

import java.util.*;

public class HowManyNumbers {

    public static List<Long> findAll(final int sumDigits, final int numDigits) {
        if (sumDigits > numDigits * 9 || sumDigits < numDigits) {
            return new ArrayList<>();
        }
        Set<Long> set = new HashSet<>();
        char[] out = new char[numDigits];
        for (int i = 1; i <= 9; i++) {
            out[0] = (char) (i + '0');
            findDigits(numDigits, sumDigits - i, out, 1, i, set);
        }
        return List.of((long) set.size(), Collections.min(set), Collections.max(set));
    }

    static void findDigits(int numDigits, int sumDigits, char[] out,
                           int index, int startingDigit, Set<Long> set) {
        if (index > numDigits || sumDigits < 0) {
            return;
        }
        if (index == numDigits) {
            if (sumDigits == 0) {
                set.add(Long.parseLong(new String(out)));
            }
            return;
        }
        for (int i = startingDigit; i <= 9; i++) {
            out[index] = (char) (i + '0');
            findDigits(numDigits, sumDigits - i, out, index + 1, i, set);
        }
    }
}
