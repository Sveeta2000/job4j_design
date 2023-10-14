package ru.job4j.interview.kyu4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AddingBigNumbersTest {

    @Test
    void test1and1() {
        assertThat(AddingBigNumbers.add("1", "1")).isEqualTo("2");
    }

    @Test
    void test123and456() {
        assertThat(AddingBigNumbers.add("123", "456")).isEqualTo("579");
    }

    @Test
    void test888and222() {
        assertThat(AddingBigNumbers.add("888", "222")).isEqualTo("1110");
    }

    @Test
    void test1372and69() {
        assertThat(AddingBigNumbers.add("1372", "69")).isEqualTo("1441");
    }

    @Test
    void test12and456() {
        assertThat(AddingBigNumbers.add("12", "456")).isEqualTo("468");
    }

    @Test
    void test100and101() {
        assertThat(AddingBigNumbers.add("100", "101")).isEqualTo("201");
    }

    @Test
    void testRealBigNumbers() {
        assertThat(AddingBigNumbers.add("63829983432984289347293874", "90938498237058927340892374089"))
                .isEqualTo("91002328220491911630239667963");
    }

    @Test
    void testStartingZeros() {
        assertThat(AddingBigNumbers.add("647111808", "005126116852794219938029961"))
                .isEqualTo("5126116852794220585141769");
    }
}