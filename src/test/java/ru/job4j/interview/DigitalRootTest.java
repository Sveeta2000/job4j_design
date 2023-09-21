package ru.job4j.interview;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DigitalRootTest {
    @Test
    public void test16() {
        assertThat(DigitalRoot.digitalRoot(16)).isEqualTo(7);
    }

    @Test
    public void test942() {
        assertThat(DigitalRoot.digitalRoot(942)).isEqualTo(6);
    }
}