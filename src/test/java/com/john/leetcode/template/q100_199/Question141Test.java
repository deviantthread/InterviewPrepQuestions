package com.john.leetcode.template.q100_199;

import com.john.datastructures.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class Question141Test {
    private Question141 classUnderTest = new Question141();

    @Test
    public void testExample1() {
        ListNode head = ListNode.create("[3,2,0,-4]");

        ListNode tail = head.getTail();
        int pos = 1;
        ListNode node = head.getIndex(pos);
        tail.next = node;
        boolean expected = true;
        //    Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
        Assert.assertEquals(expected, classUnderTest.hasCycle(head));
    }

    @Test
    public void testExample2() {
        ListNode head = ListNode.create("[1,2]");
        ListNode tail = head.getTail();
        int pos = 1;
        ListNode node = head.getIndex(pos);
        tail.next = node;

        boolean expected = true;
        //    Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
        Assert.assertEquals(expected, classUnderTest.hasCycle(head));
    }

    @Test
    public void testExample3() {
        ListNode head = ListNode.create("[1]");
        int pos = -1; // no cycle

        boolean expected = false;
        //    Explanation: There is no cycle in the linked list.
        Assert.assertEquals(expected, classUnderTest.hasCycle(head));
    }
}
