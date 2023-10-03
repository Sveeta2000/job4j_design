package ru.job4j.interview;

import org.junit.jupiter.api.Test;
import ru.job4j.interview.kyu6.Persist;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersistTest {
    @Test
    public void basicTests() {
        assertEquals(3, Persist.persistence(39));
        assertEquals(0, Persist.persistence(4));
        assertEquals(2, Persist.persistence(25));
        assertEquals(4, Persist.persistence(999));
    }
}