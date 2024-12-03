package com.john.leetcode.Nov2022.q1_99;

import com.john.datastructures.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class Question92Test {
    private Question92 classUnderTest = new Question92();

    @Test
    public void testExample1() {
        ListNode head = ListNode.create("[1,2,3,4,5]");
        int left = 2;
        int right = 4;
        ListNode expected = ListNode.create("[1,4,3,2,5]");
        Assert.assertEquals(expected, classUnderTest.reverseBetween(head, left, right));
    }

    @Test
    public void testExample2() {
        ListNode head = ListNode.create("[5]");
        int left = 1;
        int right = 1;
        ListNode expected = ListNode.create("[5]");
        Assert.assertEquals(expected, classUnderTest.reverseBetween(head, left, right));
    }

    @Test
    public void testExample3() {
        ListNode head = ListNode.create("[3,5]");
        int left = 1;
        int right = 2;
        ListNode expected = ListNode.create("[5,3]");
        Assert.assertEquals(expected, classUnderTest.reverseBetween(head, left, right));
    }
}
