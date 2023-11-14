package ru.job4j.interview.kyu6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MajorityElementEvenTest {
    MajorityElementEven m = new MajorityElementEven();

    @Test
    void testTieSlow() {
        assertThat(m.mostFrequentEven(new int[]{0, 1, 2, 2, 4, 4, 1})).isEqualTo(2);
    }

    @Test
    void testTieFast() {
        assertThat(m.mostFrequentEven2(new int[]{0, 1, 2, 2, 4, 4, 1})).isEqualTo(2);
    }

    @Test
    void test4Slow() {
        assertThat(m.mostFrequentEven(new int[]{4, 4, 4, 9, 2, 4})).isEqualTo(4);
    }

    @Test
    void test4Fast() {
        assertThat(m.mostFrequentEven2(new int[]{4, 4, 4, 9, 2, 4})).isEqualTo(4);
    }

    @Test
    void testNoneSlow() {
        assertThat(m.mostFrequentEven(new int[]{29, 47, 21, 41, 13, 37, 25, 7})).isEqualTo(-1);
    }

    @Test
    void testNoneFast() {
        assertThat(m.mostFrequentEven2(new int[]{29, 47, 21, 41, 13, 37, 25, 7})).isEqualTo(-1);
    }

}