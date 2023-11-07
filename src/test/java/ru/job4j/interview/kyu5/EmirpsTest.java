package ru.job4j.interview.kyu5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class EmirpsTest {

    @Test
    void isPrimeTestTrue() {
        assertThat(Emirps.isPrime(97)).isTrue();
        assertThat(Emirps.isPrime(2)).isTrue();
        assertThat(Emirps.isPrime(37)).isTrue();
        assertThat(Emirps.isPrime(1201)).isTrue();
    }

    @Test
    void isPrimeTestFalse() {
        assertThat(Emirps.isPrime(96)).isFalse();
        assertThat(Emirps.isPrime(14)).isFalse();
        assertThat(Emirps.isPrime(21)).isFalse();
        assertThat(Emirps.isPrime(1202)).isFalse();
    }

    @Test
    void testEmirps50() {
        assertThat(Emirps.findEmirp(50)).containsExactly(4L, 37L, 98L);
    }

    @Test
    void testEmirps0() {
        assertThat(Emirps.findEmirp(10)).containsExactly(0L, 0L, 0L);
    }
}