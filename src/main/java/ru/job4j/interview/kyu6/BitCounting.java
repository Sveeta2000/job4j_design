package ru.job4j.interview.kyu6;

public class BitCounting {

    public static int countBits(int n) {
        return Integer.toBinaryString(n).replace("0", "").length();
    }
}
