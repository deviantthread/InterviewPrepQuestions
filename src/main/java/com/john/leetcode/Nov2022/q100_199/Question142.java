package com.john.leetcode.Nov2022.q100_199;

import com.john.datastructures.ListNode;
import java.util.HashSet;
import java.util.Set;

public class Question142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> seenNodes = new HashSet<>();

        while (head != null) {
            if (seenNodes.contains(head)) {
                return head;
            }
            seenNodes.add(head);
            head = head.next;
        }

        return null;
    }
}
