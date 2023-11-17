package ru.job4j.interview.kyu5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ExelColumnsTest {
    @Test
    void testOneChar() {
        assertThat(ExelColumns.convertToTitle(1)).isEqualTo("A");
        assertThat(ExelColumns.convertToTitle(26)).isEqualTo("Z");
        assertThat(ExelColumns.convertToTitle(3)).isEqualTo("C");
    }

    @Test
    void testTwoChar() {
        assertThat(ExelColumns.convertToTitle(28)).isEqualTo("AB");
        assertThat(ExelColumns.convertToTitle(53)).isEqualTo("BA");
        assertThat(ExelColumns.convertToTitle(79)).isEqualTo("CA");
        assertThat(ExelColumns.convertToTitle(52)).isEqualTo("AZ");
    }

    @Test
    void testThreeChar() {
        assertThat(ExelColumns.convertToTitle(703)).isEqualTo("AAA");
    }
}