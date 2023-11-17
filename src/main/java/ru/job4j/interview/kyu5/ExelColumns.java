package ru.job4j.interview.kyu5;

public class ExelColumns {
    public static String convertToTitle(int columnNumber) {
        char[] abc = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int num = (columnNumber - 1) % 26;
            sb.append(abc[num]);
            columnNumber = (columnNumber - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
