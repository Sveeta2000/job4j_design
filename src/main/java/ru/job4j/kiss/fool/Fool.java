package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {
    private static int number = 1;
    private static final String FIZZ_BUZZ = "FizzBuzz";
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        Scanner scanner = new Scanner(System.in);
        while (number < 100) {
            computerTurn(number);
            number++;
            String answer = scanner.nextLine();
            playerTurn(answer);
            number++;
        }
    }

    public static void computerTurn(int currNumber) {
        if (isDivBy3And5(currNumber)) {
            System.out.println(FIZZ_BUZZ);
        } else if (isDivBy3(currNumber)) {
            System.out.println(FIZZ);
        } else if (isDivBy5(currNumber)) {
            System.out.println(BUZZ);
        } else {
            System.out.println(currNumber);
        }
    }

    public static void playerTurn(String answer) {
        validateAnswer(answer);
        if (isDivBy3And5(number) && !FIZZ_BUZZ.equals(answer)) {
            startAgain();
        } else if (isDivBy3(number) && !FIZZ.equals(answer)) {
            startAgain();
        } else if (isDivBy5(number) && !BUZZ.equals(answer)) {
            startAgain();
        }
    }

    public static void validateAnswer(String answer) {
        if (!String.valueOf(number).equals(answer) && !FIZZ.equals(answer)
                && !BUZZ.equals(answer) && !FIZZ_BUZZ.equals(answer)) {
            startAgain();
        }
    }

    private static void startAgain() {
        System.out.println("Ошибка. Начинай снова.");
        number = 0;
    }

    public static boolean isDivBy3And5(int currNumber) {
        return currNumber % 3 == 0 && currNumber % 5 == 0;
    }

    public static boolean isDivBy5(int currNumber) {
        return currNumber % 5 == 0;
    }

    public static boolean isDivBy3(int currNumber) {
        return currNumber % 3 == 0;
    }

}
