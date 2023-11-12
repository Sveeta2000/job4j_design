package ru.job4j.interview.kyu6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RepeatedSubstringTest {

    RepeatedSubstring r = new RepeatedSubstring();

    @Test
    void testTrue() {
        assertThat(r.repeatedSubstringPattern("abab")).isTrue();
        assertThat(r.repeatedSubstringPattern("aa")).isTrue();
        assertThat(r.repeatedSubstringPattern("abcabcabc")).isTrue();
    }

    @Test
    void testFalse() {
        assertThat(r.repeatedSubstringPattern("aba")).isFalse();
        assertThat(r.repeatedSubstringPattern("aabb")).isFalse();
        assertThat(r.repeatedSubstringPattern("abcabcabca")).isFalse();
    }
}