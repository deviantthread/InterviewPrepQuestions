package com.john.Nov2022.leetcode.q100_199;

import com.john.datastructures.ListNode;
import java.util.HashSet;
import java.util.Set;

public class Question141 {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();

        while (head != null) {
            if (seen.contains(head)) {
                return true;
            }
            seen.add(head);
            head = head.next;
        }

        return false;
    }
}
