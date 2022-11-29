package com.john.Nov2022.leetcode.q151_200;

import com.john.datastructures.ListNode;
import java.util.HashSet;
import java.util.Set;

public class Question160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodesInA = new HashSet<>();

        while (headA != null) {
            nodesInA.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (nodesInA.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
