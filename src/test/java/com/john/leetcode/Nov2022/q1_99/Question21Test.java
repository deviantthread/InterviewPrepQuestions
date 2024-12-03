package com.john.leetcode.Nov2022.q1_99;

import com.john.datastructures.ListNode;
import com.john.leetcode.Nov2022.q1_99.Question21;
import org.junit.Assert;
import org.junit.Test;

public class Question21Test {

    private Question21 classUnderTest = new Question21();

    @Test
    public void testExample1() {
        ListNode list1 = ListNode.create(new int[] { 1, 2, 4 });
        ListNode list2 = ListNode.create(new int[] { 1, 3, 4 });
        ListNode expected = ListNode.create(new int[] { 1, 1, 2, 3, 4, 4 });

        Assert.assertArrayEquals(expected.toArray(), classUnderTest.mergeTwoLists(list1, list2).toArray());
    }

    @Test
    public void testExample2() {
        ListNode list1 = ListNode.create(new int[] {});
        ListNode list2 = ListNode.create(new int[] {});
        ListNode expected = ListNode.create(new int[] {});

        // these are null
        Assert.assertEquals(expected, classUnderTest.mergeTwoLists(list1, list2));
    }

    @Test
    public void testExample3() {

        ListNode list1 = ListNode.create(new int[] {});
        ListNode list2 = ListNode.create(new int[] { 0 });
        ListNode expected = ListNode.create(new int[] { 0 });

        Assert.assertArrayEquals(expected.toArray(), classUnderTest.mergeTwoLists(list1, list2).toArray());
    }
}
