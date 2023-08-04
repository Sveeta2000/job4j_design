package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Check if you have provided both the root folder and the file extension");
        }
        validate(args[0], args[1]);
        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static void validate(String path, String extension) {
        if (!Files.exists(Path.of(path))) {
            throw new IllegalArgumentException(String.format("The folder %s doesn't exist", path));
        }
        if (!extension.matches("\\..+")) {
            throw new IllegalArgumentException(String.format("The extension format is not correct : %s", extension));
        }
    }
}
