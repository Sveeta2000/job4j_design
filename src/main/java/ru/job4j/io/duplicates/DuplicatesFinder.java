package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("D:\\учеба"), visitor);
        printDuplicates(visitor);
    }

    public static void printDuplicates(DuplicatesVisitor visitor) {
        for (Map.Entry<FileProperty, List<Path>> entry : visitor.getDuplicates().entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println(entry.getKey().getName() + " : " + entry.getKey().getSize());
                entry.getValue().forEach(path -> System.out.println(path.toAbsolutePath()));
            }
        }
    }
}
