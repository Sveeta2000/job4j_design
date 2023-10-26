package ru.job4j.interview.kyu6;

import java.util.Arrays;

public class GoodVsEvil {

    private static final String GOOD_WINS = "Battle Result: Good triumphs over Evil";
    private static final String EVIL_WINS = "Battle Result: Evil eradicates all trace of Good";
    private static final String TIE = "Battle Result: No victor on this battle field";

    public static String battle(String goodAmounts, String evilAmounts) {
        int good = countGood(goodAmounts);
        int evil = countEvil(evilAmounts);
        return good > evil ? GOOD_WINS : evil > good ? EVIL_WINS : TIE;
    }

    private static int countGood(String good) {
        int sum = 0;
        int[] goodWorth = new int[]{1, 2, 3, 3, 4, 10};
        int[] goodAmount = Arrays.stream(good.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < goodWorth.length; i++) {
            sum += goodAmount[i] * goodWorth[i];
        }
        return sum;
    }

    private static int countEvil(String evil) {
        int sum = 0;
        int[] evilWorth = new int[]{1, 2, 2, 2, 3, 5, 10};
        int[] evilAmount = Arrays.stream(evil.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < evilWorth.length; i++) {
            sum += evilAmount[i] * evilWorth[i];
        }
        return sum;
    }
}
