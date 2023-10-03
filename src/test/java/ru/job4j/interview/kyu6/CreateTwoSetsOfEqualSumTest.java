package ru.job4j.interview.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateTwoSetsOfEqualSumTest {

    @Test
    public void testCreateTwoSetsOfEqualSumWithOddN() {
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> set1 = new ArrayList<>(List.of(3));
        List<Integer> set2 = new ArrayList<>(Arrays.asList(2, 1));
        expected.add(set1);
        expected.add(set2);
        assertEquals(expected, CreateTwoSetsOfEqualSum.createTwoSetsOfEqualSum(3));

        expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        expected.add(new ArrayList<>());
        assertEquals(expected, CreateTwoSetsOfEqualSum.createTwoSetsOfEqualSum(5));

        expected = new ArrayList<>();
        expected.add(new ArrayList<>());
        expected.add(new ArrayList<>());
        assertEquals(expected, CreateTwoSetsOfEqualSum.createTwoSetsOfEqualSum(1));
    }
}