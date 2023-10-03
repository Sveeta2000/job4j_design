package ru.job4j.interview.kyu6;

import java.util.Stack;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        if (walk.length != 10) {
            return false;
        }
        int n = 0;
        int s = 0;
        int w = 0;
        int e = 0;
        for (char c : walk) {
            if (c == 'n') {
                n++;
            } else if (c == 's') {
                s++;
            } else if (c == 'w') {
                w++;
            } else if (c == 'e') {
                e++;
            }
        }
        return (n == s) && (w == e);
    }
}
