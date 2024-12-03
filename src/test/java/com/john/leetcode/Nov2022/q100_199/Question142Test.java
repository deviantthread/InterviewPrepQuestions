package com.john.leetcode.Nov2022.q100_199;

import com.john.datastructures.ListNode;
import com.john.leetcode.Nov2022.q100_199.Question142;
import org.junit.Assert;
import org.junit.Test;

public class Question142Test {
    private Question142 classUnderTest = new Question142();

    @Test
    public void testExample1() {
        ListNode head = ListNode.create("[3,2,0,-4]");
        int pos = 1;
        ListNode cycle = addCycle(head, pos);
        //    Output: tail connects to node index 1
        //    Explanation: There is a cycle in the linked list, where tail connects to the second node.
        Assert.assertEquals(cycle.val, classUnderTest.detectCycle(head).val);
    }

    @Test
    public void testExample2() {
        ListNode head = ListNode.create("[1,2]");
        int pos = 0;
        ListNode cycle = addCycle(head, pos);
        //    Output: tail connects to node index 0
        //    Explanation: There is a cycle in the linked list, where tail connects to the first node.
        Assert.assertEquals(cycle.val, classUnderTest.detectCycle(head).val);
    }

    @Test
    public void testExample3() {
        ListNode head = ListNode.create("[1]");
        int pos = -1;
        ListNode cycle = addCycle(head, pos);
        //    Output: no cycle
        //    Explanation: There is no cycle in the linked list.
        Assert.assertNull(classUnderTest.detectCycle(head));
    }

    private ListNode addCycle(ListNode head, int pos) {
        if (pos < 0) {
            return null;
        }

        ListNode posNode = null;

        int i = 0;
        ListNode tail = null;
        while (head != null) {
            tail = head;
            if (i == pos) {
                posNode = head;
            }

            i++;
            head = head.next;
        }

        if (tail != null) {
            tail.next = posNode;
        }

        return posNode;
    }
}
