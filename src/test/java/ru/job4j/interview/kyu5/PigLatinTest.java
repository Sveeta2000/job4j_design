package ru.job4j.interview.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PigLatinTest {
    @Test
    public void fixedTests() {
        assertEquals("igPay atinlay siay oolcay", PigLatin.pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay", PigLatin.pigIt("This is my string"));
        assertEquals("elloHay orldway !", PigLatin.pigIt("Hello world !"));
    }
}