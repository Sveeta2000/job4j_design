package ru.job4j.interview.kyu5;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Emirps {

    public static long[] findEmirp(long n) {
        if (n < 13) {
            return new long[] {0L, 0L, 0L};
        }
        Set<Long> primes = primeNumbersTill(n)
                .stream()
                .filter(x -> !isPalindrome(x))
                .filter(x -> isPrime(reverse(x)))
                .collect(Collectors.toSet());
        return new long[]{
                primes.size(),
                Collections.max(primes),
                primes.stream().mapToLong(Long::longValue).sum()};
    }

    public static Set<Long> primeNumbersTill(long n) {
        return LongStream.rangeClosed(13, n)
                .filter(Emirps::isPrime).boxed()
                .collect(Collectors.toSet());
    }

    public static boolean isPrime(long number) {
        return LongStream.rangeClosed(2, (long) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }

    private static boolean isPalindrome(long number) {
        String num = String.valueOf(number);
        return num.contentEquals(String.valueOf(reverse(number)));
    }

    private static long reverse(long number) {
        return Long.parseLong(new StringBuilder(String.valueOf(number)).reverse().toString());
    }
}
