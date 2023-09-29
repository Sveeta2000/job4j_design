package ru.job4j.interview;

public class RangeExtraction {

    public static String rangeExtraction(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        int lastIndex = 0;
        for (int i = 0; i < array.length; i++) {
            while (i < array.length - 1 && array[i] + 1 == array[i + 1]) {
                i++;
            }
            if (i - lastIndex > 1) {
                stringBuilder.append(array[lastIndex])
                        .append("-")
                        .append(array[i]);
            } else if (i - lastIndex == 1) {
                stringBuilder.append(array[--i]);
            } else {
                stringBuilder.append(array[i]);
            }
            if (i < array.length - 1) {
                stringBuilder.append(",");
            }
            lastIndex = i + 1;
        }
        return stringBuilder.toString();
    }
}
