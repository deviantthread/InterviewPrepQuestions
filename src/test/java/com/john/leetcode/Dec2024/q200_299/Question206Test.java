package com.john.leetcode.Dec2024.q200_299;

import com.john.datastructures.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class Question206Test {
    private final Question206 classUnderTest = new Question206();

    @Test
    public void testExample1() {
        ListNode head = ListNode.create("[1,2,3,4,5]");
        ListNode expected = ListNode.create("[5,4,3,2,1]");

        Assert.assertEquals(expected, classUnderTest.reverseList(head));
    }

    @Test
    public void testExample2() {
        ListNode head = ListNode.create("[1,2]");
        ListNode expected = ListNode.create("[2,1]");

        Assert.assertEquals(expected, classUnderTest.reverseList(head));
    }

    @Test
    public void testExample3() {

        ListNode head = ListNode.create("[]");
        ListNode expected = ListNode.create("[]");

        Assert.assertEquals(expected, classUnderTest.reverseList(head));
    }
}
