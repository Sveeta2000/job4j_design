package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Map<FileProperty, List<Path>> duplicates = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (Files.isRegularFile(file)) {
            FileProperty fileInfo = new FileProperty(Files.size(file), file.getFileName().toString());
            List<Path> paths = new ArrayList<>();
            if (duplicates.containsKey(fileInfo)) {
                paths = duplicates.get(fileInfo);
            }
            paths.add(file);
            duplicates.put(fileInfo, paths);
        }
        return super.visitFile(file, attrs);
    }

    public Map<FileProperty, List<Path>> getDuplicates() {
        return duplicates;
    }
}
