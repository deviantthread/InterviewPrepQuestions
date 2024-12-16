package com.john.leetcode.Dec2024.q1_99;

import com.john.datastructures.ListNode;

public class Question24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // z->a->b->c->d  head=a
        // z->b->a->d->c  head=b

        // prev = z
        // swapleft = a
        // swapright = b
        // next = c
        // prev.next = swapright
        // next = swapright.next
        // swapright.next = swapleft
        // swapleft.next = next

        ListNode newHead = head.next;

        ListNode prev = null;
        ListNode swapLeft = head;
        ListNode swapRight = head.next;
        ListNode next;

        while (swapLeft != null && swapRight != null) {
            next = swapRight.next;
            if (prev != null) {
                prev.next = swapRight;
            }
            swapRight.next = swapLeft;
            swapLeft.next = next;

            prev = swapLeft;
            swapLeft = next;
            if (swapLeft != null) {
                swapRight = next.next;
            }
        }

        return newHead;
    }
}