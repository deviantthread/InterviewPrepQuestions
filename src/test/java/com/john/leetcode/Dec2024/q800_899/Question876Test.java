package com.john.leetcode.Dec2024.q800_899;

import com.john.datastructures.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class Question876Test {
    private final Question876 classUnderTest = new Question876();

    @Test
    public void testExample1() {
        ListNode head = ListNode.create("[1,2,3,4,5]");
        ListNode expected = ListNode.create("[3,4,5]");
        //    Explanation: The middle node of the list is node 3.
        Assert.assertEquals(expected, classUnderTest.middleNode(head));
    }

    @Test
    public void testExample2() {
        ListNode head = ListNode.create("[1,2,3,4,5,6]");
        ListNode expected = ListNode.create("[4,5,6]");
        //    Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
        Assert.assertEquals(expected, classUnderTest.middleNode(head));
    }
}
