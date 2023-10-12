package ru.job4j.interview.kyu6;

public class CamelCaseTranslator {
    public static String toUnderScore(String name) {
        if (name == null || name.length() == 0) {
            return "";
        }
        return name.replaceAll("([^_\\d])(\\d)", "$1_$2")
                .replaceAll("(?<!^)(?<!_)([A-Z])", "_$1");
    }
}
