package ru.job4j.interview.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupermarketQueueTest {
    @Test
    public void testNormalCondition() {
        assertEquals(9, SupermarketQueue.solveSuperMarketQueue(new int[]{2, 2, 3, 3, 4, 4}, 2));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(0, SupermarketQueue.solveSuperMarketQueue(new int[]{}, 1));
    }

    @Test
    public void testBigN() {
        assertEquals(5, SupermarketQueue.solveSuperMarketQueue(new int[]{1, 2, 3, 4, 5}, 100));
    }

    @Test
    public void testSingleCustomer() {
        assertEquals(2, SupermarketQueue.solveSuperMarketQueue(new int[]{2}, 5));
    }

    @Test
    public void testSingleCustomerSingleTill() {
        assertEquals(5, SupermarketQueue.solveSuperMarketQueue(new int[]{5}, 1));
    }

    @Test
    public void testSingleTillManyCustomers() {
        assertEquals(15, SupermarketQueue.solveSuperMarketQueue(new int[]{1, 2, 3, 4, 5}, 1));
    }

    @Test
    public void testLongCustomerArray() {
        assertEquals(113, SupermarketQueue.solveSuperMarketQueue(new int[]{29, 18, 6, 23, 25, 29, 24, 17, 10, 8, 8, 22, 20, 16, 13, 17, 7, 21, 7, 11, 18, 26, 25, 1, 18, 29, 16, 26, 7, 11, 13, 20, 12, 6, 23, 3, 10, 9, 8, 5, 6, 18, 19, 26, 5, 15, 4, 15, 1, 4}, 7));
    }
}