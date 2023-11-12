package ru.job4j.interview.kyu6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FirstOccurrenceTest {
    FirstOccurrence f = new FirstOccurrence();

    @Test
    void whenSadInSadnessSadThen0() {
        assertThat(f.strStr("sadnesssad", "sad")).isEqualTo(0);
    }

    @Test
    void whenSadlyInSadnessThenMinus1() {
        assertThat(f.strStr("sadness", "sadly")).isEqualTo(-1);
    }

    @Test
    void whenSInSThen0() {
        assertThat(f.strStr("s", "s")).isEqualTo(0);
    }
}