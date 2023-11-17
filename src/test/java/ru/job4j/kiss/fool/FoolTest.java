package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FoolTest {

    @Test
    void testFizz() {
        assertThat(Fool.checkAnswer(18)).isEqualTo("Fizz");
        assertThat(Fool.checkAnswer(99)).isEqualTo("Fizz");
    }

    @Test
    void testBuzz() {
        assertThat(Fool.checkAnswer(25)).isEqualTo("Buzz");
        assertThat(Fool.checkAnswer(50)).isEqualTo("Buzz");
    }

    @Test
    void testFizzBuzz() {
        assertThat(Fool.checkAnswer(15)).isEqualTo("FizzBuzz");
        assertThat(Fool.checkAnswer(30)).isEqualTo("FizzBuzz");
    }

    @Test
    void testNumbers() {
        assertThat(Fool.checkAnswer(16)).isEqualTo("16");
        assertThat(Fool.checkAnswer(31)).isEqualTo("31");
    }
}