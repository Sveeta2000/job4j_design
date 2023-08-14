package ru.job4j.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        validateParams(argsName);
        String delimiter = argsName.get("delimiter");
        StringBuilder result = new StringBuilder();
        String[] filterOrder = argsName.get("filter").split(",");
        try (Scanner scanner = new Scanner(Path.of(argsName.get("path")), StandardCharsets.UTF_8)) {
            if (scanner.hasNext()) {
                List<String> columnHeaders = List.of(scanner.nextLine().split(delimiter));
                if (!columnHeaders.containsAll(List.of(filterOrder))) {
                    throw new IndexOutOfBoundsException("The file does not contain all the required filters");
                }
                result.append(String.join(delimiter, filterOrder)).append(System.lineSeparator());
                while (scanner.hasNext()) {
                    List<String> filteredLine = new ArrayList<>();
                    String[] line = scanner.nextLine().split(delimiter);
                    for (String header : filterOrder) {
                        int index = columnHeaders.indexOf(header);
                        filteredLine.add(line[index]);
                    }
                    result.append(String.join(delimiter, filteredLine)).append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if ("stdout".equals(argsName.get("out"))) {
            System.out.println(result);
        } else {
            Files.writeString(Path.of(argsName.get("out")), result.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 4) {
            throw new IllegalArgumentException("The program must be started with 4 args : -path, -delimiter, -out, -filter");
        }
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }

    private static void validateParams(ArgsName args) {
        if (!Files.isRegularFile(Path.of(args.get("path")))) {
            throw new IllegalArgumentException(String.format("Wrong file name : %s", args.get("path")));
        }
        if (!(";".equals(args.get("delimiter"))) && !(",".equals(args.get("delimiter")))) {
            throw new IllegalArgumentException(String.format("Unsupported delimiter \" %s \"", args.get("delimiter")));
        }
        if (!("stdout".equals(args.get("out"))) && !args.get("out").endsWith(".csv")) {
            throw new IllegalArgumentException(String.format("Unsupported output %s", args.get("out")));
        }
    }
}
