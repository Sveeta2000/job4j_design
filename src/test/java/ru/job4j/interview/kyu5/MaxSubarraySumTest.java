package ru.job4j.interview.kyu5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MaxSubarraySumTest {

    @Test
    public void testAllNegative() {
        assertThat(MaxSubarraySum.sequence(new int[]{-1, -2, -3})).isEqualTo(0);
        assertThat(MaxSubarraySum.sequence(new int[]{-1, -2, -3, -1, -20})).isEqualTo(0);
    }

    @Test
    public void testAllPositive() {
        assertThat(MaxSubarraySum.sequence(new int[]{1, 2, 3, 0})).isEqualTo(6);
        assertThat(MaxSubarraySum.sequence(new int[]{1, 2, 3, 20})).isEqualTo(26);
    }

    @Test
    public void testEmpty() {
        assertThat(MaxSubarraySum.sequence(new int[]{})).isEqualTo(0);
    }

    @Test
    public void testDifferent() {
        assertThat(MaxSubarraySum.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})).isEqualTo(6);
        assertThat(MaxSubarraySum.sequence(new int[]{1, 2, 3, -6, 10, -5, 6})).isEqualTo(11);
    }
}