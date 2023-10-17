package ru.job4j.interview.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberExpandedFormTest {
    @Test
    public void testSomething() {
        assertEquals("10 + 2", NumberExpandedForm.expandedForm(12));
        assertEquals("40 + 2", NumberExpandedForm.expandedForm(42));
        assertEquals("70000 + 300 + 4", NumberExpandedForm.expandedForm(70304));
    }
}