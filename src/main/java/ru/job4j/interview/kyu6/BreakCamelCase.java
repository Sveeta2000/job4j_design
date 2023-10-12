package ru.job4j.interview.kyu6;

public class BreakCamelCase {

    /**
     Method adds a space before all upper-case letters
     that are not at the beginning of the String.
     $1 and $2 are references to the first and second groups of the regex.
     */
    public static String noCamelCase(String input) {
        return input.replaceAll("(.)([A-Z])", "$1 $2");
    }
}
