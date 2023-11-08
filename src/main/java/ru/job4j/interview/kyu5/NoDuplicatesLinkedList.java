package ru.job4j.interview.kyu5;

import java.util.HashSet;
import java.util.Set;

public class NoDuplicatesLinkedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> generalSet = new HashSet<>();
        Set<Integer> duplicatesSet = new HashSet<>();
        ListNode prevNode = head;
        ListNode result = head;
        while (head != null) {
            if (!generalSet.contains(head.val)) {
                generalSet.add(head.val);
                if (duplicatesSet.contains(result.val)) {
                    result = head;
                }
                if (head.next != null && head.val != head.next.val) {
                    prevNode = head;
                }
            } else {
                duplicatesSet.add(head.val);
                prevNode.next = head.next;
            }
            head = head.next;
        }
        if (duplicatesSet.contains(result.val)) {
            result = null;
        }
        return result;
    }

    public ListNode deleteDuplicatesRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int v = head.val;
        if (head.next.val != v) {
            head.next = deleteDuplicatesRecursive(head.next);
            return head;
        }
        while (head != null && v == head.val) {
            head = head.next;
        }
        return deleteDuplicatesRecursive(head);
    }
}
