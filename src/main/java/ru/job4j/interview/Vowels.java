package ru.job4j.interview;

public class Vowels {
    public static int getCount(String str) {
        return (int) str.chars().filter(x -> Character.toString(x).matches("[aeuio]")).count();
    }
}
