package ru.job4j.interview.kyu6;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class OddDigPrime {
    public static long[] onlyOddDigPrimes(long n) {
        Set<Long> belowNumbers = primeNumbersTill(n);
        long above = n % 2 == 0 ? n + 1 : n;
        while (!isOdd(above) || !isPrime(above)) {
            above += 2;
        }
        return new long[] {belowNumbers.size(), Collections.max(belowNumbers), above};
    }

    public static Set<Long> primeNumbersTill(long n) {
        return LongStream.rangeClosed(3, n)
                .filter(OddDigPrime::isOdd)
                .filter(OddDigPrime::isPrime)
                .boxed()
                .collect(Collectors.toSet());
    }

    public static boolean isPrime(long number) {
        return LongStream.rangeClosed(2, number - 1)
                .allMatch(n -> number % n != 0);
    }

    public static boolean isOdd(long number) {
        while (number > 0) {
            if ((number % 10) % 2 == 0) {
                return false;
            }
            number /= 10;
        }
        return true;
    }
}
