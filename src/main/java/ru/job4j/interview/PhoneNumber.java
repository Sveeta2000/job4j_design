package ru.job4j.interview;

public class PhoneNumber {
    public static String createPhoneNumber(int[] numbers) {
        if (numbers.length != 10) {
            throw new IllegalArgumentException();
        }
        StringBuilder stringBuilder = new StringBuilder("(");
        for (int i = 0; i < numbers.length; i++) {
            if (i == 3) {
                stringBuilder.append(") ");
            }
            if (i == 6) {
                stringBuilder.append("-");
            }
            stringBuilder.append(numbers[i]);
        }
        return stringBuilder.toString();
    }
}
