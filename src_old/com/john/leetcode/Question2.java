package com.john.leetcode;

public class Question2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        int remainder = 0;

        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + remainder;
            remainder = val / 10;
            val = val % 10;
            prev.next = new ListNode(val);
            prev = prev.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int val = l1.val + remainder;
            remainder = val / 10;
            val = val % 10;
            prev.next = new ListNode(val);
            prev = prev.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int val = l2.val + remainder;
            remainder = val / 10;
            val = val % 10;
            prev.next = new ListNode(val);
            prev = prev.next;
            l2 = l2.next;
        }

        if (remainder != 0) {
            prev.next = new ListNode(remainder);
        }

        return preHead.next;
    }
}
