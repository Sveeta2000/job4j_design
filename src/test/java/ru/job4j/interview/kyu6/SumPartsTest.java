package ru.job4j.interview.kyu6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SumPartsTest {

    //new int[] {}, new int[] {0});
    //        dotest(new int[] {0, 1, 3, 6, 10}, new int[] {20, 20, 19, 16, 10, 0});
    //        dotest(new int[] {1, 2, 3, 4, 5, 6}, new int[] {21, 20, 18, 15, 11, 6, 0});
    //        dotest(new int[] {744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358},
    //                new int[] {10037855, 9293730, 9292795, 9292388, 9291934, 9291504, 9291414, 9291270, 2581057, 2580168, 2579358, 0});
    @Test
    void test() {
        int[] input = new int[] {0, 1, 3, 6, 10};
        int[] expected = new int[] {20, 20, 19, 16, 10, 0};
        assertThat(SumParts.sumParts(input)).containsExactly(expected);
    }

}