package com.john.leetcode.Dec2024.q1_99;

import com.john.datastructures.ListNode;

public class Question19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // move a pointer out n steps
        ListNode end = head;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }

        ListNode nthNode = head;
        ListNode prevNthNode = head;
        // start a new pointer from head, when end reaches end, we've found the nth node
        while (end != null) {
            end = end.next;
            prevNthNode = nthNode;
            nthNode = nthNode.next;
        }

        if (nthNode == head) {
            return head.next;
        } else {
            prevNthNode.next = nthNode.next;
            return head;
        }
    }
}
