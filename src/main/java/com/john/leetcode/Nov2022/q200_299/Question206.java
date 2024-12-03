package com.john.leetcode.Nov2022.q200_299;

import com.john.datastructures.ListNode;

public class Question206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }


        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while (next != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
