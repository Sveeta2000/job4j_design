package ru.job4j.interview;

public class FindNameInString {
    public static boolean nameInStr(String str, String name) {
        char[] line = str.toLowerCase().toCharArray();
        int index = 0;
        StringBuilder foundName = new StringBuilder();
        for (char letter : name.toLowerCase().toCharArray()) {
            for (int i = index; i < line.length; i++) {
                if (letter == line[i]) {
                    foundName.append(line[i]);
                    index = i + 1;
                    break;
                }
            }
        }
        return foundName.toString().equals(name);
    }
}
