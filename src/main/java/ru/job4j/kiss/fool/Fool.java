package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        int number = 1;
        Scanner scanner = new Scanner(System.in);
        while (number < 100) {
            System.out.println(checkAnswer(number++));
            String answer = scanner.nextLine();
            if (!answer.equals(checkAnswer(number))) {
                System.out.println("Ошибка. Начинай снова.");
                number = 0;
            }
            number++;
        }
    }

    public static String checkAnswer(int number) {
        String out = String.format("%s%s",
                number % 3 == 0 ? "Fizz" : "",
                number % 5 == 0 ? "Buzz" : "");
        return out.isEmpty() ? String.valueOf(number) : out;
    }
}
