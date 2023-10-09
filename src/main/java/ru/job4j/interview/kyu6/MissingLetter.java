package ru.job4j.interview.kyu6;

public class MissingLetter {
    public static char findMissingLetter(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] - array[i] != 1) {
                return (char) (array[i] + 1);
            }
        }
        return '0';
    }
}
