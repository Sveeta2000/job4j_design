package ru.job4j.interview;

public class Prime {
    public static boolean isPrime(int num) {
        boolean prime = true;
        if (num <= 1) {
            prime = false;
        } else {
            int root = (int) Math.sqrt(num);
            for (int i = 2; i <= root; i++) {
                if (num % i == 0) {
                    prime = false;
                    break;
                }
            }
        }
        return prime;
    }
}
