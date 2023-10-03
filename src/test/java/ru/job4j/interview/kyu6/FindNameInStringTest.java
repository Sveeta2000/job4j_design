package ru.job4j.interview.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindNameInStringTest {
    @Test
    public void sampleTest() {
        assertTrue(FindNameInString.nameInStr("Across the rivers", "chris"));
        assertFalse(FindNameInString.nameInStr("Next to a lake", "chris"));
        assertFalse(FindNameInString.nameInStr("Under a sea", "chris"));
        assertFalse(FindNameInString.nameInStr("A crew that boards the ship", "chris"));
        assertFalse(FindNameInString.nameInStr("A live son", "Allison"));
    }
}