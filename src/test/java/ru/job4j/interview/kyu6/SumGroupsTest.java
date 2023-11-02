package ru.job4j.interview.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumGroupsTest {
    @Test
    public void basicTests() {
        assertEquals(6, SumGroups.sumGroups(new int[]{2, 1, 2, 2, 6, 5, 0, 2, 0, 5, 5, 7, 7, 4, 3, 3, 9}));
        assertEquals(5, SumGroups.sumGroups(new int[]{2, 1, 2, 2, 6, 5, 0, 2, 0, 3, 3, 3, 9, 2}));
        assertEquals(1, SumGroups.sumGroups(new int[]{2}));
        assertEquals(2, SumGroups.sumGroups(new int[]{1, 2}));
        assertEquals(1, SumGroups.sumGroups(new int[]{1, 1, 2, 2}));
    }
}