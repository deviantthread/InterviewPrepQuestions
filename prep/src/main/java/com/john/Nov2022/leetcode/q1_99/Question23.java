package com.john.Nov2022.leetcode.q1_99;

import com.john.datastructures.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Question23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // populate the priority queue
        PriorityQueue<Node> nodes = new PriorityQueue<>(Comparator.comparing(Node::getValue));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                nodes.offer(new Node(listNode.val, listNode));
            }
        }

        ListNode preHead = new ListNode();
        ListNode curr = preHead;

        while (!nodes.isEmpty()) {
            //grab the smallest element and remove it from the queue adding it to our list
            Node leastNode = nodes.poll();
            curr.next = leastNode.list;
            curr = curr.next;

            // if that list has more numbers, add the new head back on the queue
            if (curr.next != null) {
                nodes.offer(new Node(curr.next.val, curr.next));
            }
        }

        return preHead.next;
    }

    private class Node {
        int value;
        ListNode list;

        public Node(int value, ListNode list) {
            this.value = value;
            this.list = list;
        }

        public int getValue() {
            return value;
        }
    }
}
