package com.john.leetcode.Dec2024.q1_99;

import com.john.datastructures.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Question23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        ListNode newHead = null;

        // add everything into the heap
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }

        ListNode curr = null;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            if (node.next != null) {
                heap.offer(node.next);
            }
            node.next = null;

            if (newHead == null) {
                newHead = node;
                curr = node;
            } else {
                curr.next = node;
                curr = curr.next;
            }
        }

        return newHead;
    }
}