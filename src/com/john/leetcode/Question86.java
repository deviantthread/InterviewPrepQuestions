package com.john.leetcode;

public class Question86 {

    public static void main(String[] args) {
        ListNode head = ListNode.generateNodes("1->4->3->2->5->2");
        ListNode.printNodes(head, "original");

        ListNode partition = new Question86().partition(head, 3);
        ListNode.printNodes(partition, "partition");
    }

    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(-1);
        ListNode afterHead = new ListNode(-1);
        ListNode beforeCurr = beforeHead;
        ListNode afterCurr = afterHead;

        while (head != null) {
            if (head.val < x) {
                beforeCurr.next = head;
                beforeCurr = beforeCurr.next;
            } else {
                afterCurr.next = head;
                afterCurr = afterCurr.next;
            }
            head = head.next;
        }

        afterCurr.next = null;
        beforeCurr.next = afterHead.next;

        return beforeHead.next;
    }
}
