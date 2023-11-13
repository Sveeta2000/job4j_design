package ru.job4j.interview.kyu6;

public class Palindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase());
        return sb.toString().contentEquals(sb.reverse());
    }
}
