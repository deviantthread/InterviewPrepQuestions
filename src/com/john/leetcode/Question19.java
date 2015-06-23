package com.john.leetcode;

public class Question19 {

    public static void main(String[] args) {
        ListNode head = ListNode.generateNodes(1);
        ListNode.printNodes(head, "head");
        int n = 1;
        ListNode updated = new Question19().removeNthFromEnd(head, n);

        ListNode.printNodes(updated, "updated");
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode first = head;

        for (int i = 0; i <= n; i++) {
            // delete head
            if (first == null && i == n) {
                return head.next;
            }
            first = first.next;
        }

        ListNode nodeToDel = head;
        while (first != null) {
            first = first.next;
            nodeToDel = nodeToDel.next;
        }

        ListNode nextNode = nodeToDel.next != null ? nodeToDel.next.next : null;
        nodeToDel.next = nextNode;

        return head;
    }
}
