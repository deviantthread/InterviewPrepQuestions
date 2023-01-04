package com.john.Nov2022.leetcode.q51_100;

import com.john.datastructures.ListNode;

public class Question92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //nothing to reverse
        if (left == right) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = new ListNode();

        // walk left nodes
        for (int i = 1; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }

        ListNode headOfReversal = curr;
        ListNode tailOfLeft = prev;

        // walk right nodes
        for (int i = left; i < right; i++) {
            curr = curr.next;
        }

        ListNode tailOfReversal = curr;
        ListNode headOfRight = curr.next;

        // break the reversal from the rest of the list
        tailOfReversal.next = null;

        //reverse middle list
        reverse(headOfReversal);

        // connect it back up, keeping in mind the tails/heads of middle bit have switched
        tailOfLeft.next = tailOfReversal;
        headOfReversal.next = headOfRight;

        if (left == 1) { // the head changed
            return tailOfReversal;
        } else {
            return head;
        }
    }

    private void reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
