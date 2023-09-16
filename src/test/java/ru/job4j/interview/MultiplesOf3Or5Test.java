package ru.job4j.interview;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MultiplesOf3Or5Test {

    @Test
    public void test10() {
        assertThat(23).isEqualTo(new MultiplesOf3Or5().solution(10));
    }

}