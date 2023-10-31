package ru.job4j.interview.kyu4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HowManyNumbersTest {
    @Test
    public void exampleTests() {
        assertEquals(Arrays.asList(8L, 118L, 334L),         HowManyNumbers.findAll(10, 3));
        assertEquals(Arrays.asList(1L, 999L, 999L),         HowManyNumbers.findAll(27, 3));
        assertEquals(new ArrayList<Long>(),                 HowManyNumbers.findAll(84, 4));
        assertEquals(Arrays.asList(123L, 116999L, 566666L), HowManyNumbers.findAll(35, 6));
    }

    @Test
    public void largeTests() {
        assertEquals(Arrays.asList(519L, 11129999L, 55555556L), HowManyNumbers.findAll(41, 8));
        assertEquals(Arrays.asList(902L, 111169999L, 555555556L),  HowManyNumbers.findAll(46, 9));
        assertEquals(Arrays.asList(319L, 11399999L, 66666677L), HowManyNumbers.findAll(50, 8));
        assertEquals(Arrays.asList(194L, 11799999L, 66777777L), HowManyNumbers.findAll(54, 8));
    }
}