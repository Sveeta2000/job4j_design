package ru.job4j.interview.kyu4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MorseCodeDecoderAdvanced {

    private static Map<String, String> morseCodeMap = new HashMap<>();
    private static String[] morse = new String[] {".-", "A", "-...", "B", "-.-.", "C", "-..", "D", ".", "E", "..-.", "F",
            "--.", "G", "....", "H", "..", "I", ".---", "J", "-.-", "K", ".-..", "L",
            "--", "M", "-.", "N", "---", "O", ".--.", "P", "--.-", "Q", ".-.", "R",
            "...", "S", "-", "T", "..-", "U", "...-", "V", ".--", "W", "-..-", "X",
            "-.--", "Y", "--..", "Z",
            "-----", "0", ".----", "1", "..---", "2", "...--", "3", "....-", "4",
            ".....", "5", "-....", "6", "--...", "7", "---..", "8", "----.", "9",
            ".-.-.-", ".", "--..--", ",", "..--..", "?", ".----.", "'", "-.-.--", "!",
            "-..-.", "/", "-.--.", "(", "-.--.-", ")", ".-...", "&", "---...", ",",
            "-.-.-.", ";", "-...-", "=", ".-.-.", "+", "-....-", "-", "..--.-", "_",
            ".-..-.", "\"", "...-..-", "$", ".--.-.", "@", "...---...", "SOS"};

    static {
        for (int i = 0; i < morse.length; i += 2) {
            morseCodeMap.put(morse[i], morse[i + 1]);
        }
    }

    public static String decodeBits(String bits) {
        bits = trimZeros(bits);
        int times = findTimes(bits);
        if (times == -1) {
            return ".";
        }
        return Arrays.stream(bits.split("0{" + 7 * times + "}"))
                .map(word -> Arrays.stream(word.split("0{" + 3 * times + "}"))
                        .map(symb -> Arrays.stream(symb.split("0{" + times + "}"))
                                .map(s -> s.length() == 3 * times ? "-" : ".")
                                .collect(Collectors.joining()))
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.joining("   "));
    }

    private static String trimZeros(String bits) {
        if (bits.startsWith("0")) {
            bits = bits.replaceFirst("0+", "");
        }
        if (bits.endsWith("0")) {
            String rev = new StringBuilder(bits).reverse().toString();
            bits = rev.replaceFirst("0+", "");
            bits = new StringBuilder(bits).reverse().toString();
        }
        return bits;
    }

    private static int findTimes(String bits) {
        int timesOne = bits.indexOf('0');
        if (timesOne == -1) {
            return -1;
        }
        int timesZero = timesOne;
        int countZero = 0;
        int countOne = 0;
        for (int i = timesOne; i < bits.length(); i++) {
            if (bits.charAt(i) == '1') {
                countOne++;
                timesZero = countZero == 0 ? timesZero : Math.min(countZero, timesZero);
            } else {
                countZero++;
                timesOne = countOne == 0 ? timesOne : Math.min(countOne, timesOne);
                countOne = 0;
            }
        }
        System.out.println("timesOne = " + timesOne + " timesZero = " + timesZero);
        return Math.min(timesOne, timesZero);
    }

    public static void main(String[] args) {
        MorseCodeDecoderAdvanced.decodeBits("00011100111001100000011111100");
        System.out.println(Arrays.toString("110000000000000011".split("0{" + 7 * 2 + "}")));
    }

    public static String decodeMorse(String morseCode) {
        return Arrays.stream(morseCode.trim().split("   "))
                .map(s -> Arrays.stream(s.split(" "))
                        .map(l -> morseCodeMap.get(l))
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(" "));
    }

}
