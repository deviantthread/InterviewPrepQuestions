package com.john.leetcode;

public class Question142 {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        ListNode cycle = new ListNode(-1);
        for (int i = 1; i < 1; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        curr.next = cycle;
        cycle.next = head;

        ListNode detectCycle = new Question142().detectCycle(head);
        System.out.println(detectCycle == null ? null : detectCycle.val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;

            if (fast.next == null) {
                return null;
            }

            fast = fast.next.next;

            if (slow == fast) {
                return slow;
            }
        }

        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
