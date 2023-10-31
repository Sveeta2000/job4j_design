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
        smallest = findSmallest(sumDigits, numDigits);
        Set<Long> longSet = generateNumbers(sumDigits, numDigits);
        return List.of((long) longSet.size(), smallest, biggest);
    }

    private static Set<Long> generateNumbers(int sumDigits, int numDigits) {
        Set<Long> set = new HashSet<>();
        long num = smallest;
        while (num <= biggest) {
            if (sumDigits == countSum(num)) {
                if (isConsec(num)) {
                    set.add(num);
                    num += 9;
                } else {
                    num += 9;
                    //num = skipNonConsecutive(num, numDigits);
                }
            } else {
                num += 9;
            }
        }
        return set;
    }

    private static boolean isConsec(long l) {
        while (l != 0) {
            if ((l % 10) < ((l / 10) % 10)) {
                return false;
            }
            l /= 10;
        }
        return true;
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

    private static long findSmallest(int sumDigits, int numDigits) {
        if (sumDigits / numDigits > 9) {
            return -1;
        }
        StringBuilder number = new StringBuilder("1".repeat(numDigits));
        int leftover = sumDigits - numDigits;
        int index = numDigits - 1;
        while (leftover > 0) {
            if (leftover >= 8) {
                number.setCharAt(index, '9');
                leftover -= 8;
            } else {
                number.setCharAt(index, (char) ('1' + leftover));
                leftover -= leftover;
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

    private static long skipNonConsecutive(long number, int numDigits) { //redo
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

        System.out.println(findSmallest(35, 6));
        System.out.println(findSmallest(10, 3));
        System.out.println(findSmallest(27, 3));
        System.out.println(findSmallest(84, 4));
    }

}
