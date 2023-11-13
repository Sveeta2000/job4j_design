package ru.job4j.interview.kyu6;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = list1.val > list2.val ? list2 : list1;
        ListNode result = head;
        if (head.equals(list1)) {
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                head.next = list2;
                list2 = list2.next;
            } else {
                head.next = list1;
                list1 = list1.next;
            }
            head = head.next;
        }
        if (list2 != null) {
            head.next = list2;

        }
        if (list1 != null) {
            head.next = list1;
        }
        return result;
    }
}
