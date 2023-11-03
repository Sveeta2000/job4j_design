package ru.job4j.interview.kyu5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LongestSubstringTest {
    private final LongestSubstring ls = new LongestSubstring();

    @Test
    void testWhenABCThen3() {
        assertThat(ls.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
    }

    @Test
    void testWhenBThen1() {
        assertThat(ls.lengthOfLongestSubstring("bbbbbb")).isEqualTo(1);
    }

    @Test
    void testWhenWKEThen3() {
        assertThat(ls.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
    }

    @Test
    void testWhenEmptyThen0() {
        assertThat(ls.lengthOfLongestSubstring("")).isEqualTo(0);
    }
}