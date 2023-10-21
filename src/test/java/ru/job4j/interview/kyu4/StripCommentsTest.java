package ru.job4j.interview.kyu4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StripCommentsTest {
    @Test
    public void stripComments() {
        assertEquals(
                "apples, pears\ngrapes\nbananas",
                StripComments.stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[]{"#", "!"})
        );

        assertEquals(
                "a\nc\nd",
                StripComments.stripComments("a #b\nc\nd $e f g", new String[]{"#", "$"})
        );
    }

    @Test
    public void stripCommentsRandom() {
        assertEquals(
                "a\n\n\n\n\n\nec",
                StripComments
                        .stripComments("a-ef\n\n-c\n\n-\n\nec", new String[]{"#", "$", "!", "-"})
        );
    }
}