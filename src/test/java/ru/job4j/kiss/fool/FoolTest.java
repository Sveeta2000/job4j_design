package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FoolTest {

    @Test
    void when15IsDivBy3And5ThenTrue() {
        assertThat(Fool.isDivBy3And5(15)).isTrue();
    }

    @Test
    void when20IsDivBy5ThenTrue() {
        assertThat(Fool.isDivBy5(20)).isTrue();
    }

    @Test
    void when18IsDivBy3ThenTrue() {
        assertThat(Fool.isDivBy3(18)).isTrue();
    }

    @Test
    void when18IsDivBy3And5ThenFalse() {
        assertThat(Fool.isDivBy3And5(18)).isFalse();
    }

    @Test
    void when21IsDivBy5ThenFalse() {
        assertThat(Fool.isDivBy5(21)).isFalse();
    }

    @Test
    void when20IsDivBy3ThenFalse() {
        assertThat(Fool.isDivBy3(20)).isFalse();
    }
}