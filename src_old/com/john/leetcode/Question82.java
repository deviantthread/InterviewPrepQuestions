package com.john.leetcode;

public class Question82 {

    public static void main(String[] args) {
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(Integer.MAX_VALUE);
        newHead.next = head;
        boolean del = false;
        ListNode curr = newHead;
        while (curr != null && curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                curr.next = curr.next.next;
                del = true;
            } else if (del) {
                curr.next = curr.next.next;
                del = false;
            } else {
                curr = curr.next;
            }
        }
        if (del) {
            curr.next = null;
        }

        return newHead.next;
    }

}
