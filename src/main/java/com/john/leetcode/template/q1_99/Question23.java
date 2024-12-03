package com.john.leetcode.template.q1_99;

import com.john.datastructures.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Question23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // put the link lists into a sort of map
        // head value -> rest of list

        // sort map by head value
        // grab first element of map, replacing with next element of its list
        // go to sort map
        // replace empty linked list with null
        // stop sorting when first element of map is null
        // all this time be creating the result linked list.
        // lotsa sorting of k items

        sortNodes(lists);

        ListNode preHead = new ListNode();
        ListNode curr = preHead;
        while (lists[0] != null) {
            ListNode lowestNode = lists[0];
            curr.next = lowestNode;
            curr = curr.next;
            lists[0] = lowestNode.next;

            sortNodes(lists);
        }

        return preHead.next;
    }

    private void sortNodes(ListNode[] lists) {
        int lowestIdx = -1;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                if (lowestIdx < 0 || lists[i].val < lists[lowestIdx].val) {
                    lowestIdx = i;
                }
            }
        }

        if (lowestIdx >= 0) {
            ListNode tmp = lists[0];
            lists[0] = lists[lowestIdx];
            lists[lowestIdx] = tmp;
        }
    }

    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
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
