package com.john.leetcode.template.q1_99;

import com.john.datastructures.ListNode;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class Question19Test {
    private Question19 classUnderTest = new Question19();

    @Test
    public void testExample1() {
        ListNode head = ListNode.create("[1,2,3,4,5]");
        int n = 2;
        ListNode expected = ListNode.create("[1,2,3,5]");
        Assert.assertEquals(expected, classUnderTest.removeNthFromEnd(head, n));
    }

    @Test
    public void testExample2() {
        ListNode head = ListNode.create("[1]");
        int n = 1;
        ListNode expected = ListNode.create("[]");
        Assert.assertEquals(expected, classUnderTest.removeNthFromEnd(head, n));
    }

    @Test
    public void testExample3() {
        ListNode head = ListNode.create("[1,2]");
        int n = 1;
        ListNode expected = ListNode.create("[1]");
        Assert.assertEquals(expected, classUnderTest.removeNthFromEnd(head, n));
    }
}
