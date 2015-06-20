package com.john.leetcode;

public class Question24 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode.generateNodes(head, 10);
        ListNode.printNodes(head);

        ListNode newHead = new Question24().swapPairs(head);
        ListNode.printNodes(newHead);

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;

        ListNode prev = null;
        ListNode first = head;
        ListNode second = null;
        ListNode next = null;
        while (first != null) {

            second = first.next;
            next = second != null ? second.next : null;
            swap(prev, first, second, next);

            prev = first;
            first = next;
        }

        return newHead;
    }

    private void swap(ListNode prev, ListNode first, ListNode second, ListNode next) {
        if (prev != null && second != null) {
            prev.next = second;
        }
        if (second != null) {
            second.next = first;
        }
        first.next = next;
    }

}
