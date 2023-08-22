package ru.job4j.io.filesearcher;

import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class FileSearcher {
    public static void main(String[] args) throws IOException {
     if (args.length < 4) {
         throw new IllegalArgumentException("There must be 4 arguments");
     }
     ArgsName argsName = ArgsName.of(args);
     validateArguments(argsName);
     Predicate<Path> condition = defineConditionByType(argsName);
     List<Path> foundFiles = Search.search(Path.of(argsName.get("d")), condition);
     printToFile(foundFiles, argsName.get("o"));
    }

    private static void printToFile(List<Path> list, String fileName) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            for (Path path : list) {
                writer.println(path.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Predicate<Path> defineConditionByType(ArgsName args) {
        Predicate<Path> condition;
        switch (args.get("t")) {
            case "name" :
                condition = s -> s.toString().equals(args.get("n"));
                break;
            case "regex" :
                condition = s -> s.toString().matches(args.get("n"));
                break;
            case "mask" :
                String reg = args.get("n").replace(".", "\\.")
                        .replace("*", ".*")
                        .replace("?", ".");
                condition = s -> s.toString().matches(reg);
                break;
            default: throw new IllegalArgumentException("Type must be one of these: mask, name or regex");
        }
        return condition;
    }

    private static void validateArguments(ArgsName args) {
        if (!Files.isDirectory(Path.of(args.get("d")))) {
            throw new IllegalArgumentException("The first argument must be a directory");
        }
        if (!args.get("o").matches(".+\\..+")) {
            throw new IllegalArgumentException("The last argument must be a file name");
        }
        if (!"mask".equals(args.get("t")) && !"name".equals(args.get("t")) && !"regex".equals(args.get("t"))) {
            throw new IllegalArgumentException("The third argument must be one of these: mask, name or regex");
        }
        if (args.get("n").length() < 3) {
            throw new IllegalArgumentException("Invalid file name or mask or regex");
        }
    }
}
