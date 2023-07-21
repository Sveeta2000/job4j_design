package ru.job4j.interview;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static ru.job4j.interview.BraceChecker.isValid;

class BraceCheckerTest {
    @Test
    public void whenActionThenResult() {
        assertThat(isValid("(){}[]")).isEqualTo(true);
        assertThat(isValid("([{}])")).isEqualTo(true);
        assertThat(isValid("(}")).isEqualTo(false);
        assertThat(isValid("[(])")).isEqualTo(false);
        assertThat(isValid("[({})](]")).isEqualTo(false);
        assertThat(isValid("(((({{")).isEqualTo(false);
        assertThat(isValid("())({}}{()][][")).isEqualTo(false);
        assertThat(isValid(")(}{][")).isEqualTo(false);
    }
}