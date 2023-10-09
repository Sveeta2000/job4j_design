package ru.job4j.interview.kyu6;

public class Tower {
    public static String[] towerBuilder(int nFloors) {
        String[] tower = new String[nFloors];
        int spaces = nFloors - 1;
        int stars = 1;
        for (int i = 0; i < nFloors; i++) {
            String floor = " ".repeat(spaces)
                    + "*".repeat(stars)
                    + " ".repeat(spaces);
            spaces--;
            stars += 2;
            tower[i] = floor;
        }
        return tower;
    }
}
