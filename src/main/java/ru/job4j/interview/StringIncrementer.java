package ru.job4j.interview;

public class StringIncrementer {
    public static String increment(String str) {
        if (str == null || str.equals("")) {
            return "1";
        }
        StringBuilder number = new StringBuilder();
        StringBuilder chars = new StringBuilder(str);
        chars.reverse();
        int i = 0;
        while (i < str.length() && Character.isDigit(chars.charAt(i))) {
            number.append(Character.getNumericValue(chars.charAt(i)));
            i++;
        }
        if (number.length() == 0) {
            return str + 1;
        }
        chars.delete(0, number.length()).reverse();
        number.reverse();
        i = number.length() - 1;
        if (Character.getNumericValue(number.charAt(i)) < 9) {
            number.setCharAt(i, (char) (number.charAt(i) + 1));
            return chars.append(number).toString();
        }
        while (i >= 0 && Character.getNumericValue(number.charAt(i)) == 9) {
            number.setCharAt(i, '0');
            i--;
        }
        if (i == -1) {
            number.append('0');
            i = 0;
        }
        number.setCharAt(i, (char) (number.charAt(i) + 1));
        return chars.append(number).toString();
    }
}