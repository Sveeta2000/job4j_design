package ru.job4j.interview.kyu6;

import java.util.Arrays;

public class DeadFish {

    public static int[] parse(String data) {
        int[] result = new int[(int) Arrays.stream(data.split("")).filter(s -> s.equals("o")).count()];
        int num = 0;
        int index = 0;
        for (String s : data.split("")) {
            if (s.equals("o")) {
                result[index] = num;
                index++;
            } else {
                num = doMath(s, num);
            }
        }
        return result;
    }

    private static int doMath(String s, int num) {
        return switch (s) {
            case "i" -> num + 1;
            case "d" -> num - 1;
            case "s" -> num * num;
            default -> num;
        };
    }
}
