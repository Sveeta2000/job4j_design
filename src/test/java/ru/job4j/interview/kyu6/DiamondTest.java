package ru.job4j.interview.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class DiamondTest {
    @Test
    public void testDiamond3() {
        String expected = """
                 *
                ***
                 *
                """;

        assertEquals(expected, Diamond.print(3));
    }

    @Test
    public void testDiamond5() {
        String expected = """
                  *
                 ***
                *****
                 ***
                  *
                """;

        assertEquals(expected, Diamond.print(5));
    }

    @Test
    public void testDiamond1() {
        assertEquals("*\n", Diamond.print(1));
    }

    @Test
    public void testDiamond0() {
        assertNull(Diamond.print(0));
    }

    @Test
    public void testDiamondMinus2() {
        assertNull(Diamond.print(-2));
    }

    @Test
    public void testDiamond2() {
        assertNull(Diamond.print(2));
    }
}