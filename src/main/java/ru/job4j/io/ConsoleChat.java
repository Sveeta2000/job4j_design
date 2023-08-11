package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> phrases = readPhrases();
        List<String> log = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();
        boolean stopped = false;
        while (!OUT.equals(line)) {
            log.add(line);
            if (STOP.equals(line)) {
                stopped = true;
            } else if (CONTINUE.equals(line)) {
                stopped = false;
            }
            if (!stopped) {
                String answer = getRandomPhrase(phrases);
                log.add(answer);
                System.out.println(answer);
            }
            line = reader.nextLine();
        }
        log.add(line);
        saveLog(log);
    }

    private String getRandomPhrase(List<String> phrases) {
        Random random = new Random();
        int index = random.nextInt(phrases.size());
        return phrases.get(index);
    }

    private List<String> readPhrases() {
        List<String> phrases = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8))) {
            phrases = reader.lines().toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8, true)))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("data/chat_with_the_bot.txt", "data/bot_phrases.txt");
        cc.run();
    }
}
