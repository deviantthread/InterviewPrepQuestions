package com.john.leetcode;

public class Question206 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i < 20; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        ListNode reversed = new Question206().reverseList(head);

        while (reversed != null) {
            System.out.print(reversed.val + "->");
            reversed = reversed.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
