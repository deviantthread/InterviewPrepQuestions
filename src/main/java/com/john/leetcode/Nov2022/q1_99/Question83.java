package com.john.leetcode.Nov2022.q1_99;

import com.john.datastructures.ListNode;

public class Question83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            // curr.next is dup, kill it
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                // curr.next is unique, bump curr up
                curr = curr.next;
            }
        }

        return head;
    }
}
