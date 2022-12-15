package com.john.Nov2022.leetcode.q1_50;

import com.john.datastructures.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class Question23Test {
    private Question23 classUnderTest = new Question23();

    @Test
    public void testExample1() {
        ListNode[] lists = { ListNode.create("[1,4,5]"),
            ListNode.create("[1,3,4]"),
            ListNode.create("[2,6]") };
        ListNode expected = ListNode.create("[1,1,2,3,4,4,5,6]");
        Assert.assertEquals(expected, classUnderTest.mergeKLists(lists));
        //    Explanation: The linked-lists are:
        //        [
        //        1->4->5,
        //        1->3->4,
        //        2->6
        //        ]
        //    merging them into one sorted list:
        //        1->1->2->3->4->4->5->6
    }

    @Test
    public void testExample2() {
        ListNode[] lists = new ListNode[0];
        ListNode expected = null;
        Assert.assertEquals(expected, classUnderTest.mergeKLists(lists));
    }

    @Test
    public void testExample3() {
        ListNode[] lists = { null };
        ListNode expected = null;
        Assert.assertEquals(expected, classUnderTest.mergeKLists(lists));
    }
}
