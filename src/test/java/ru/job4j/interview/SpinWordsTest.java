package ru.job4j.interview;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SpinWordsTest {
    @Test
    public void test() {
        assertThat(new SpinWords().spinWords("Welcome")).isEqualTo("emocleW");
        assertThat(new SpinWords().spinWords("Hey fellow warriors")).isEqualTo("Hey wollef sroirraw");
    }
}