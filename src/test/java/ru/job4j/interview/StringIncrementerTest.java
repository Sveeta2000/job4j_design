package ru.job4j.interview;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringIncrementerTest {

    @Test
    void testFar000() {
        assertThat(StringIncrementer.increment("far000")).isEqualTo("far001");
    }

    @Test
    void testFar99() {
        assertThat(StringIncrementer.increment("far99")).isEqualTo("far100");
    }

    @Test
    void test1() {
        assertThat(StringIncrementer.increment("1")).isEqualTo("2");
    }

    @Test
    void testRandom() {
        assertThat(StringIncrementer.increment("+,3Xk'c7.ECbr!E{8I93571519841524990650"))
                .isEqualTo("+,3Xk'c7.ECbr!E{8I93571519841524990651");
    }
}