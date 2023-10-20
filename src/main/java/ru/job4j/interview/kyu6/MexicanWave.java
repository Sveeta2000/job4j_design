package ru.job4j.interview.kyu6;

public class MexicanWave {
    public static String[] wave(String str) {
        if (str.length() == 0) {
            return new String[] {};
        }
        String[] wave = new String[str.replaceAll(" +", "").length()];
        int arrIndex = 0;
        for (int i = 0; arrIndex < wave.length && i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                wave[arrIndex] = str.substring(0, i) + Character.toUpperCase(str.charAt(i))
                        + str.substring(i + 1);
                arrIndex++;
            }
        }
        return wave;
    }
}
