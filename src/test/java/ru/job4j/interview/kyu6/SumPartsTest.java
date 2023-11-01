package ru.job4j.interview.kyu6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SumPartsTest {
    @Test
    void test() {
        int[] input = new int[] {0, 1, 3, 6, 10};
        int[] expected = new int[] {20, 20, 19, 16, 10, 0};
        assertThat(SumParts.sumParts(input)).containsExactly(expected);
    }
}