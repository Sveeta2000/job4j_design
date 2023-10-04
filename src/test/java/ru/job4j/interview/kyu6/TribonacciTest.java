package ru.job4j.interview.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TribonacciTest {
    @Test
    public void sampleTests() {
        double precision = 1e-10;
        assertArrayEquals(new double[]{1, 1, 1, 3, 5, 9, 17, 31, 57, 105}, Tribonacci.tribonacci(new double[]{1, 1, 1}, 10), precision);
        assertArrayEquals(new double[]{0, 0, 1, 1, 2, 4, 7, 13, 24, 44}, Tribonacci.tribonacci(new double[]{0, 0, 1}, 10), precision);
        assertArrayEquals(new double[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81}, Tribonacci.tribonacci(new double[]{0, 1, 1}, 10), precision);
    }

}