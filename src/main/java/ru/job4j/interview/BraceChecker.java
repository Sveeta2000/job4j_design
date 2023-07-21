package ru.job4j.interview;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class BraceChecker {
    private static Map<Character, Character> bracesRef = Map.of(')', '(',
            ']', '[',  '}', '{');

    public static boolean isValid(String braces) {
        boolean valid = true;
        Deque<Character> stack = new LinkedList<>();
        for (char c : braces.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if ((bracesRef.get(c) != stack.pollFirst())) {
                valid = false;
                break;
            }
        }
        return stack.isEmpty() && valid;
    }
}
