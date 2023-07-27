package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(target, true)))) {
            String stopWorkingTime = null;
            String line;
            while ((line = reader.readLine()) != null) {
                boolean working = line.startsWith("200") || line.startsWith("300");
                if (!working && stopWorkingTime == null) {
                        stopWorkingTime = line.substring(4);
                } else if (stopWorkingTime != null && working) {
                    writer.printf("%s;%s%n", stopWorkingTime, line.substring(4));
                    stopWorkingTime = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
