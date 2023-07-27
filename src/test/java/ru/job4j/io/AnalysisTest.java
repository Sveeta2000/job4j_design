package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class AnalysisTest {
    @Test
    void analyseAvailability(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter writer = new PrintWriter(source)) {
            writer.printf("200 10:56:01\n" + "500 10:57:01\n"
                    + "400 10:58:01\n" + "300 10:59:01\n"
                    + "500 11:01:02\n" + "200 11:02:02");
        }
        File target = tempDir.resolve("target.txt").toFile();
        Analysis analysis = new Analysis();
        analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        ArrayList<String> rsl = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(rsl::add);
        }
        assertThat(List.of("10:57:01;10:59:01", "11:01:02;11:02:02")).isEqualTo(rsl);
    }

    @Test
    void analyseAvailability2(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter writer = new PrintWriter(source)) {
            writer.printf("200 10:56:01\n" + "500 10:57:01\n"
                    + "400 10:58:01\n" + "500 10:59:01\n"
                    + "400 11:01:02\n" + "300 11:02:02");
        }
        File target = tempDir.resolve("target.txt").toFile();
        Analysis analysis = new Analysis();
        analysis.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        ArrayList<String> rsl = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(rsl::add);
        }
        assertThat(List.of("10:57:01;11:02:02")).isEqualTo(rsl);
    }
}