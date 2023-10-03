package ru.job4j.interview.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DirReductionTest {
    @Test
    public void testSimpleDirReduc() {
        assertArrayEquals(new String[]{"WEST"},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
        assertArrayEquals(new String[]{},
                DirReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"}));
    }
}