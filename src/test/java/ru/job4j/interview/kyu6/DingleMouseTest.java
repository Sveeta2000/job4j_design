package ru.job4j.interview.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DingleMouseTest {
    @Test
    public void testBob27Male() {
        DingleMouse dm = new DingleMouse().setName("Bob").setAge(27).setSex('M');
        String expected = "Hello. My name is Bob. I am 27. I am male.";
        assertEquals(expected, dm.hello());
    }

    @Test
    public void test27MaleBob() {
        DingleMouse dm = new DingleMouse().setAge(27).setSex('M').setName("Bob");
        String expected = "Hello. I am 27. I am male. My name is Bob.";
        assertEquals(expected, dm.hello());
    }

    @Test
    public void testAliceFemale() {
        DingleMouse dm = new DingleMouse().setName("Alice").setSex('F');
        String expected = "Hello. My name is Alice. I am female.";
        assertEquals(expected, dm.hello());
    }

    @Test
    public void testBatman() {
        DingleMouse dm = new DingleMouse().setName("Batman");
        String expected = "Hello. My name is Batman.";
        assertEquals(expected, dm.hello());
    }
}