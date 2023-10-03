package ru.job4j.interview.kyu6;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PangramChecker {

    public boolean check(String sentence) {
        Set<String> sent = Stream.of(sentence.toLowerCase()
                        .replaceAll("[^a-z]", "").split(""))
                .collect(Collectors.toSet());
        Set<String> alphabet = new HashSet<>(List.of("abcdefghijklmnopqrstuvwxyz".split("")));
        return sent.size() == 26 && sent.containsAll(alphabet);
    }
}
