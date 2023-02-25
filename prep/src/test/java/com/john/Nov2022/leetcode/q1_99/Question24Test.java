package com.john.Nov2022.leetcode.q1_99;

import com.john.datastructures.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class Question24Test {
    private Question24 classUnderTest = new Question24();

    @Test
    public void testExample1() {

        ListNode head = ListNode.create("[1,2,3,4]");
        ListNode expected = ListNode.create("[2,1,4,3]");

        Assert.assertEquals(expected, classUnderTest.swapPairs(head));
    }

    @Test
    public void testExample2() {

        ListNode head = ListNode.create("[]");
        ListNode expected = ListNode.create("[]");

        Assert.assertEquals(expected, classUnderTest.swapPairs(head));
    }

    @Test
    public void testExample3() {

        ListNode head = ListNode.create("[1]");
        ListNode expected = ListNode.create("[1]");

        Assert.assertEquals(expected, classUnderTest.swapPairs(head));
    }

    @Test
    public void testExample4() {

        ListNode head = ListNode.create("[1,2,3]");
        ListNode expected = ListNode.create("[2,1,3]");

        Assert.assertEquals(expected, classUnderTest.swapPairs(head));
    }
}
