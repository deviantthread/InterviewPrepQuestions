package com.john.leetcode.Dec2024.q1_99;

import com.john.datastructures.ListNode;

public class Question25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        ListNode frontTail = null;
        ListNode backHead = null;
        ListNode curr = head;

        while (curr != null) {
            if(frontTail != null) {
                frontTail.next = curr;
            }
            int i;
            for (i = 0; i < k && curr != null; i++) {
                curr = curr.next;
            }
            if(i < k) {
                break;
            }

            backHead = curr.next;
            curr.next = null;
            reverse(frontTail.next);
        }

        return newHead;
    }

    private void reverse(ListNode next) {

    }
}
