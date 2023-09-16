package ru.job4j.interview;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GreedTest {
    @Test
    public void test250() {
        assertThat(Greed.greedy(new int[]{5, 1, 3, 4, 1})).isEqualTo(250);
    }

    @Test
    public void test1100() {
        assertThat(Greed.greedy(new int[]{1, 1, 1, 3, 1})).isEqualTo(1100);
    }

    @Test
    public void test450() {
        assertThat(Greed.greedy(new int[]{2, 4, 4, 5, 4})).isEqualTo(450);
    }
}