package com.john.leetcode;

public class Question21 {

    public static void main(String[] args) {

        ListNode l1 = ListNode.generateNodes(1);
        ListNode l2 = new ListNode(5);
        ListNode.generateNodes(l2, 5);
        ListNode.printNodes(l1, "l1");
        ListNode.printNodes(l2, "l2");

        ListNode merged = new Question21().mergeTwoLists(l1, l2);
        ListNode.printNodes(merged, "merged");

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode curr = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        } else if (l2 != null) {
            curr.next = l2;
        }

        return head;
    }
}
