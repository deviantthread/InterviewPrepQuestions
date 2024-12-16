package com.john.leetcode.template.q1_99;

import com.john.datastructures.ListNode;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class Question25Test {
    private Question25 classUnderTest = new Question25();

    @Test
    public void testExample1() {
        ListNode head = ListNode.create("[1,2,3,4,5]");
        int k = 2;
        ListNode expected = ListNode.create("[2,1,4,3,5]");
        Assert.assertEquals(expected, classUnderTest.reverseKGroup(head, k));
    }

    @Test
    public void testExample2() {
        ListNode head = ListNode.create("[1,2,3,4,5]");
        int k = 3;
        ListNode expected = ListNode.create("[3,2,1,4,5]");
        Assert.assertEquals(expected, classUnderTest.reverseKGroup(head, k));
    }
}
