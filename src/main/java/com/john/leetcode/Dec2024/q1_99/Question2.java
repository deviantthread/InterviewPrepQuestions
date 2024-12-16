package com.john.leetcode.Dec2024.q1_99;

import com.john.datastructures.ListNode;

public class Question2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode();
        ListNode curr = preHead;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int total = l1.val + l2.val + carry;
            int value = total % 10;
            carry = total / 10;

            curr.next = new ListNode(value);
            curr = curr.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int total = l1.val + carry;
            int value = total % 10;
            carry = total / 10;

            curr.next = new ListNode(value);
            curr = curr.next;

            l1 = l1.next;
        }

        while (l2 != null) {
            int total = l2.val + carry;
            int value = total % 10;
            carry = total / 10;

            curr.next = new ListNode(value);
            curr = curr.next;

            l2 = l2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return preHead.next;
    }
}