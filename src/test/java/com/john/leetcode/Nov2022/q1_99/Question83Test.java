package com.john.leetcode.Nov2022.q1_99;

import com.john.datastructures.ListNode;
import com.john.leetcode.Nov2022.q1_99.Question83;
import org.junit.Assert;
import org.junit.Test;

public class Question83Test {
    private Question83 classUnderTest = new Question83();

    @Test
    public void testExample1() {

        ListNode head = ListNode.create("[1,1,2]");
        ListNode expected = ListNode.create("[1,2]");

        Assert.assertEquals(expected, classUnderTest.deleteDuplicates(head));
    }

    @Test
    public void testExample2() {

        ListNode head = ListNode.create("[1,1,2,3,3]");
        ListNode expected = ListNode.create("[1,2,3]");

        Assert.assertEquals(expected, classUnderTest.deleteDuplicates(head));
    }
}