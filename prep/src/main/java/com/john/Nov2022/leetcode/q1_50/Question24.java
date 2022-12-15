package com.john.Nov2022.leetcode.q1_50;

import com.john.datastructures.ListNode;

public class Question24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode prev = new ListNode();
        ListNode first = head;
        ListNode second = null;
        ListNode next = null;

        // starting as
        // prev -> first -> second -> next
        // becomes
        // prev -> second -> first -> next

        // then next iteration
        // prev = first
        // first = next
        // second = next.next
        // next = second.next
        while (first != null) {
            // lets assume second is not null
            second = first.next;

            // connect to last iteration
            prev.next = second != null ? second : first;

            if (second != null) {
                next = second.next; // for later
            } else {
                next = null;
            }

            // swap nodes
            first.next = null; // it'll be assigned as prev.next later if needed
            if (second != null) {
                second.next = first;
            }

            // to start next iteration
            prev = first;
            first = next;
        }

        return newHead;
    }
}
