package ru.job4j.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LikesTest {
    @Test
    public void staticTests() {
        assertEquals("no one likes this", Likes.whoLikesIt());
        assertEquals("Peter likes this", Likes.whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", Likes.whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", Likes.whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", Likes.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }
}