package com.john.leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode [" + val + "]";
    }

    public static ListNode generateNodes(int nodes) {
        ListNode head = new ListNode(0);
        generateNodes(head, nodes);
        return head;
    }

    public static void generateNodes(ListNode head, int nodes) {
        ListNode curr = head;
        for (int i = head.val + 1; i < head.val + nodes; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
    }

    public static void printNodes(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("\n");
    }

    public static void printNodes(ListNode head, String msg) {
        System.out.println(msg);
        printNodes(head);
    }

}
