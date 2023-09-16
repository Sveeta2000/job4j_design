package ru.job4j.interview;

public class Greed {
    public static int greedy(int[] dice) {
        if (dice.length != 5) {
            throw new IllegalArgumentException("There must be 5 dice rolls sharp");
        }
        int[] counts = new int[7];
        for (int die : dice) {
            counts[die]++;
        }
        int sum = 0;
        for (int number = 1; number <= 6; number++) {
            if (counts[number] >= 3) {
                sum += number == 1 ? 1000 : number * 100;
                counts[number] -= 3;
            }
            if (number == 1) {
                sum += counts[number] * 100;
            }
            if (number == 5) {
                sum += counts[number] * 50;
            }
        }
        return sum;
    }
}
