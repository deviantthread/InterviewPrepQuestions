package com.john.leetcode;

public class Question141 {

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

        System.out.println(new Question141().hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;

            if (fast.next == null) {
                return false;
            }

            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
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
