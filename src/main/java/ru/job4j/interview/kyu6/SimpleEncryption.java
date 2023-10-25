package ru.job4j.interview.kyu6;

public class SimpleEncryption {
    public static String encrypt(final String text, final int n) {
        if (text == null || text.length() == 0 || n < 1) {
            return text;
        }
        String result = text;
        for (int i = 0; i < n; i++) {
            StringBuilder odd = new StringBuilder();
            StringBuilder even = new StringBuilder();
            for (int j = 0; j < text.length(); j++) {
                if (j % 2 == 0) {
                    even.append(result.charAt(j));
                } else {
                    odd.append(result.charAt(j));
                }
            }
            result = odd + even.toString();
        }
        return result;
    }

    public static String decrypt(final String encryptedText, final int n) {
        if (encryptedText == null || encryptedText.length() == 0 || n < 1) {
            return encryptedText;
        }
        boolean moreEvenIndices = encryptedText.length() % 2 == 1;
        int halfLength = encryptedText.length() / 2;
        StringBuilder result = new StringBuilder(encryptedText);
        for (int i = 0; i < n; i++) {
            StringBuilder odd = new StringBuilder(result.substring(0, halfLength));
            StringBuilder even = new StringBuilder(result.substring(halfLength));
            for (int j = 0; j < halfLength; j++) {
                result.append(even.charAt(j));
                result.append(odd.charAt(j));
            }
            if (moreEvenIndices) {
                result.append(even.charAt(even.length() - 1));
            }
            result.delete(0, encryptedText.length());
        }
        return result.toString();
    }
}
