package ru.job4j.interview.kyu4;

public class AddingBigNumbers {
    public static String add(String a, String b) {
        if (a.startsWith("0")) {
            a = a.replaceFirst("0+", "");
        }
        if (b.startsWith("0")) {
            b = b.replaceFirst("0+", "");
        }
        String reverseA = new StringBuilder(a).reverse().toString();
        String reverseB = new StringBuilder(b).reverse().toString();
        StringBuilder reverseResult = new StringBuilder("0");
        int length = Math.max(a.length(), b.length());
        for (int i = 0; i < length; i++) {
            int resultNum = reverseResult.length() > i ? Character.getNumericValue(reverseResult.charAt(i)) : 0;
            int aNum = 0;
            if (i < a.length()) {
                aNum = Character.getNumericValue(reverseA.charAt(i));
            }
            int bNum = 0;
            if (i < b.length()) {
                bNum = Character.getNumericValue(reverseB.charAt(i));
            }
            int sum = resultNum + aNum + bNum;
            if (reverseResult.length() == i) {
                reverseResult.append("0");
            }
            if (sum > 9) {
                reverseResult.setCharAt(i, String.valueOf(sum - 10).charAt(0));
                reverseResult.append(1);
            } else {
                reverseResult.setCharAt(i, String.valueOf(sum).charAt(0));
            }
        }
        return reverseResult.reverse().toString();
    }
}
