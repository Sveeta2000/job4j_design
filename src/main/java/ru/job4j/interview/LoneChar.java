package ru.job4j.interview;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LoneChar {
    public static char[] loneliest(String s) {
        Map<Character, Integer> lettersAndSpaces = new HashMap<>();
        char[] chars = s.trim().toCharArray();
        char lastLetter = chars[0];
        int lastLetterIndex = 0;
        lettersAndSpaces.put(lastLetter, lastLetterIndex);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != ' ') {
                int spaces = i - lastLetterIndex - 1;
                lettersAndSpaces.put(lastLetter, lettersAndSpaces.get(lastLetter) + spaces);
                lastLetter = chars[i];
                lastLetterIndex = i;
                lettersAndSpaces.put(lastLetter, spaces);
            }
        }
        int maxSpaces = Collections.max(lettersAndSpaces.values());
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : lettersAndSpaces.entrySet()) {
            if (entry.getValue() == maxSpaces) {
                result.append(entry.getKey());
            }
        }
        return result.toString().toCharArray();
    }
}
