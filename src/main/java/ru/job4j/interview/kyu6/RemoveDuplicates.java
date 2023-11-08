package ru.job4j.interview.kyu6;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode prevNode = head;
        ListNode result = head;
        while (head != null) {
            if (!set.contains(head.val)) {
                set.add(head.val);
                prevNode = head;
            } else {
                prevNode.next = head.next;
            }
            head = head.next;
        }
        return result;
    }
}
