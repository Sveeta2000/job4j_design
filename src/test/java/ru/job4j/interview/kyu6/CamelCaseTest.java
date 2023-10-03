package ru.job4j.interview.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CamelCaseTest {
    @Test
    public void testSomeUnderscoreLowerStart() {
        String input = "the_Stealth_Warrior";
        System.out.println("input: " + input);
        assertEquals("theStealthWarrior", CamelCase.toCamelCase(input));
    }

    @Test
    public void testSomeDashLowerStart() {
        String input = "the-Stealth-Warrior";
        System.out.println("input: " + input);
        assertEquals("theStealthWarrior", CamelCase.toCamelCase(input));
    }
}