package ru.job4j.interview.kyu4;

import java.util.*;

public class HowManyNumbers {

    private static long biggest;
    private static long smallest;

    public static List<Long> findAll(final int sumDigits, final int numDigits) {
        if (sumDigits > numDigits * 9 || sumDigits < numDigits) {
            return new ArrayList<>();
        }
        biggest = findBiggest(sumDigits, numDigits);
        Set<Long> longSet = generateNumbers(sumDigits, numDigits);
        return List.of((long) longSet.size(), Collections.min(longSet), biggest);
    }

    public static long findBiggest(int sumDigits, int numDigits) {
        int digit = sumDigits / numDigits;
        if (digit > 9) {
            return -1;
        }
        StringBuilder number = new StringBuilder(String.valueOf(digit).repeat(numDigits));
        int leftover = sumDigits % numDigits;
        int index = numDigits - 1;
        while (leftover > 0) {
            if (number.charAt(index) < '9') {
                number.setCharAt(index, (char) (number.charAt(index) + 1));
                leftover--;
            }
            index--;
            if (index == -1) {
                index = numDigits - 1;
            }
        }
        return Long.parseLong(number.toString());
    }

    private static int countSum(long num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private static Set<Long> generateNumbers(int sumDigits, int numDigits) {
        Set<Long> set = new HashSet<>();
        long num = 0;
        long val = 1;
        for (int i = 0; i < numDigits; i++) {
            num += val;
            val *= 10;
        }
        while (num <= biggest) {
            if (sumDigits == countSum(num)) {
                if (isConsecutive(num)) {
                    set.add(num);
                    num += 9;
                } else {
                    num = skipNonConsecutive(num, numDigits);
                }
            } else {
                num++;
            }
        }
        return set;
    }

    private static boolean isConsecutive(long number) {
        String num = String.valueOf(number);
        for (int i = 0; i < num.length() - 1; i++) {
            if (num.charAt(i) > num.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static long skipNonConsecutive(long number, int numDigits) {
        String n = Long.toString(number).substring(0, 1);
        int next = Integer.parseInt(n) + 1;
        return Long.parseLong(String.valueOf(next).repeat(numDigits));
    }

    public static void main(String[] args) {
       System.out.println(findBiggest(35, 6));
       System.out.println(findBiggest(10, 3));
       System.out.println(findBiggest(27, 3));
       System.out.println(findBiggest(84, 4));
        System.out.println(findBiggest(36, 4));
        System.out.println(findBiggest(20, 4));
        System.out.println(findBiggest(37, 5));
        System.out.println(findBiggest(22, 8));
    }

}
