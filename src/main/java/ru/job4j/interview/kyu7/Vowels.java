package ru.job4j.interview.kyu7;

public class Vowels {
    public static int getCount(String str) {
        return (int) str.chars().filter(x -> Character.toString(x).matches("[aeuio]")).count();
    }
}
