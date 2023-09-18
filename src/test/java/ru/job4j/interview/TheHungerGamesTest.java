package ru.job4j.interview;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TheHungerGamesTest {
    @Test
    public void ex1() {
        final String before = "CCC[CCC]FCC[CCCCC]CFFFF[CCC]FFFF";
        final String after  = "...[CCC]F..[CCCCC].FFFF[CCC]FFFF";
        assertThat(TheHungerGames.hungryFoxes(before)).isEqualTo(after);
    }

    @Test
    public void ex2() {
        final String before = "...[CCC]...[CCCFC].....[CCC]....";
        final String after  = "...[CCC]...[...F.].....[CCC]....";
        assertThat(TheHungerGames.hungryFoxes(before)).isEqualTo(after);
    }

    @Test
    public void ex3() {
        final String before = "CCC[CCC]FCC[CCCFC]CFFFF[CCC]FFFF";
        final String after  = "...[CCC]F..[...F.].FFFF[CCC]FFFF";
        assertThat(TheHungerGames.hungryFoxes(before)).isEqualTo(after);
    }

    @Test
    public void ex4() {
        final String before = ".C.C[..CC.C..F..FC.]C.C";
        final String after  = ".C.C[........F..F..]C.C";
        assertThat(TheHungerGames.hungryFoxes(before)).isEqualTo(after);
    }
}