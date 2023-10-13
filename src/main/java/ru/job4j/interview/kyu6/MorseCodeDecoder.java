package ru.job4j.interview.kyu6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MorseCodeDecoder {

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

    public static String decode(String morseCode) {
        return Arrays.stream(morseCode.trim().split("   "))
                .map(s -> Arrays.stream(s.split(" "))
                        .map(l -> morseCodeMap.get(l))
                        .collect(Collectors.joining()))
                .collect(Collectors.joining(" "));
    }
}
