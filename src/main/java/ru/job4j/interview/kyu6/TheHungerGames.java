package ru.job4j.interview.kyu6;

public class TheHungerGames {
    public static String hungryFoxes(final String farm) {
        StringBuilder sb = new StringBuilder(farm);
        if (farm.contains("F")) {
            int startCageIndex = 0;
            boolean foxInCage = false;
            boolean inCage = false;
            boolean foxOut = false;
            for (int i = 0; i < farm.length(); i++) {
                if (farm.charAt(i) == '[') {
                    startCageIndex = i;
                    inCage = true;
                } else if (farm.charAt(i) == ']') {
                    inCage = false;
                }
                if (farm.charAt(i) == 'F' && inCage) {
                    foxInCage = true;
                } else if (farm.charAt(i) == 'F') {
                    foxOut = true;
                }
                if (foxInCage && inCage) {
                    while (farm.charAt(startCageIndex) != ']') {
                        if (farm.charAt(startCageIndex) == 'C') {
                            sb.setCharAt(startCageIndex, '.');
                        }
                        startCageIndex++;
                    }
                    inCage = false;
                    foxInCage = false;
                    i = startCageIndex;
                }
            }
            if (foxOut) {
                for (int i = 0; i < farm.length(); i++) {
                    if (farm.charAt(i) == 'C' && !inCage) {
                        sb.setCharAt(i, '.');
                    }
                    if (farm.charAt(i) == '[') {
                        inCage = true;
                    }
                    if (farm.charAt(i) == ']') {
                        inCage = false;
                    }
                }
            }
        }
        return sb.toString();
    }
}