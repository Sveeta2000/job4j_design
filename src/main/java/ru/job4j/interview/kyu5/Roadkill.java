package ru.job4j.interview.kyu5;

import java.util.HashSet;
import java.util.Set;

public class Roadkill {
    static String roadKill(final String photo) {
        StringBuilder str = new StringBuilder(photo.replace("=", ""));
        if (str.isEmpty()) {
            return "??";
        }
        for (String animal : Preloaded.ANIMALS) {
            if (containsAllChars(animal, str.toString())) {
                if (animal.startsWith(String.valueOf(str.charAt(0)))
                        && tryAnimal(animal, str.toString())) {
                    return animal;
                } else if (animal.startsWith(String.valueOf(str.reverse().charAt(0)))
                        && tryAnimal(animal, str.toString())) {
                    return animal;
                }
            }
        }
        return "??";
    }

    /**
     * This method tries to recreate the name of the animal from the test string
     *
     * @param animal is an animal from the list to check with
     * @param test   is the string we are trying to identify
     * @return true if we managed to recreate the animal name, false otherwise
     */
    private static boolean tryAnimal(String animal, String test) {
        int animalIndex = 0;
        int testIndex = 0;
        StringBuilder result = new StringBuilder();
        while (animalIndex < animal.length() && testIndex < test.length()) {
            if (animal.charAt(animalIndex) == test.charAt(testIndex)) {
                result.append(test.charAt(testIndex));
                animalIndex++;
            }
            testIndex++;
        }
        return animal.contentEquals(result);
    }

    public static Set<Character> stringToCharacterSet(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    /**
     * This method checks if testStr only contains the characters that are present in the animal name,
     * and no extra characters
     *
     * @param animal  is an animal from the list to check with
     * @param testStr is the string we are trying to check
     * @return true if testStr contains only the characters that are present in the animal name, false otherwise
     */
    public static boolean containsAllChars(String animal, String testStr) {
        return stringToCharacterSet(animal).containsAll(stringToCharacterSet(testStr));
    }

    public static void main(String[] args) {
        String s = Roadkill.roadKill("======pe====nnnnnn=======================n=n=ng====u==iiii=iii==nn========================n=");
        System.out.println(s);
    }

    /**
     * Same as roadKill method but nicer
     */
    static String roadKillRegex(final String photo) {
        String edited = photo.replaceAll("=", "");
        String reversed = new StringBuffer(edited).reverse().toString();

        for (String animal : Preloaded.ANIMALS) {
            String regex = animal.replaceAll("", "+").replaceFirst(".", "");
            if (edited.matches(regex) || reversed.matches(regex)) {
                return animal;
            }
        }
        return "??";
    }
}
