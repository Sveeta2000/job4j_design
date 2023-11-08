package ru.job4j.interview.kyu5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NoDuplicatesLinkedListTest {

    private final NoDuplicatesLinkedList ndl = new NoDuplicatesLinkedList();

    @Test
    void testHeadRepeatedRec() {
        ListNode four = new ListNode(3, null);
        ListNode three = new ListNode(2, four);
        ListNode two = new ListNode(1, three);
        ListNode one = new ListNode(1, two);
        ListNode head = new ListNode(1, one);
        assertThat(ndl.deleteDuplicatesRecursive(head)).isEqualTo(three);
    }

    @Test
    void testHeadRepeated() {
        ListNode four = new ListNode(3, null);
        ListNode three = new ListNode(2, four);
        ListNode two = new ListNode(1, three);
        ListNode one = new ListNode(1, two);
        ListNode head = new ListNode(1, one);
        assertThat(ndl.deleteDuplicates(head)).isEqualTo(three);
    }
}