package com.john.Nov2022.leetcode.q151_200;

import com.john.datastructures.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class Question160Test {

    private Question160 classUnderTest = new Question160();

    @Test
    public void testExample1() {

        int intersectVal = 8;
        ListNode listA = ListNode.create("[4,1,8,4,5]");
        ListNode listB = ListNode.create("[5,6,1,8,4,5]");
        int skipA = 2;
        int skipB = 3;
        int expected = 8;
        Question160Test.combine(listA, listB, skipA, skipB);
        //    Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
        //    From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
        Assert.assertEquals(expected, classUnderTest.getIntersectionNode(listA, listB).val);
        //- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
    }

    @Test
    public void testExample2() {

        int intersectVal = 2;
        ListNode listA = ListNode.create("[1,9,1,2,4]");
        ListNode listB = ListNode.create("[3,2,4]");
        int skipA = 3;
        int skipB = 1;
        Question160Test.combine(listA, listB, skipA, skipB);
        int expected = 2;
        //    Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
        //    From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
        Assert.assertEquals(expected, classUnderTest.getIntersectionNode(listA, listB).val);
    }

    @Test
    public void testExample3() {
        int intersectVal = 0;
        ListNode listA = ListNode.create("[2,6,4]");
        ListNode listB = ListNode.create("[1,5]");
        int skipA = 3;
        int skipB = 2;
        Question160Test.combine(listA, listB, skipA, skipB);
        Integer expected = null;
        //    Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
        //        Explanation: The two lists do not intersect, so return null.
        Assert.assertEquals(expected, classUnderTest.getIntersectionNode(listA, listB));
    }

    @Test
    public void testCombineFunction() {
        ListNode listA = ListNode.create("[4,1,8,1,2]");
        ListNode listB = ListNode.create("[5,6,1,8,4,5]");

        ListNode listExpectedA = ListNode.create("[4,1,8,4,5]"); // 1,2 should have changed to 4,5
        ListNode listExpectedB = ListNode.create("[5,6,1,8,4,5]");

        int skipA = 2;
        int skipB = 3;

        combine(listA, listB, skipA, skipB);

        Assert.assertEquals(listExpectedA, listA);
        Assert.assertEquals(listExpectedB, listB);
    }

    private static void combine(ListNode listA, ListNode listB, int skipA, int skipB) {
        int aIdx = 0;
        int bIdx = 0;
        while (++aIdx < skipA) {
            listA = listA.next;
        }

        while(bIdx++ < skipB) {
            listB = listB.next;
        }

        listA.next = listB;
    }
}