package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("data/even.txt")) {
            StringBuilder str = new StringBuilder();
            int num;
            while ((num = in.read()) != -1) {
                str.append((char) num);
            }
            String[] numbers = str.toString().split(System.lineSeparator());
            for (String number : numbers) {
                num = Integer.parseInt(number);
                boolean even = num % 2 == 0;
                System.out.println(num + " - " + (even ? "четное" : "нечетное"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
