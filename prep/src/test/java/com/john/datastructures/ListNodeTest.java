package com.john.datastructures;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListNodeTest {

    @Test
    public void testGenerate() {
        ListNode head = ListNode.generateNodes("[1,2,3,4,56,789]");

        assertEquals(6, head.length());
    }

    @Test
    public void testPrint() {
        ListNode head = ListNode.generateNodes("[1,2,3,4,56,789]");

        head.print();
    }

    @Test
    public void testToArray() {
        ListNode head = ListNode.generateNodes("[1,2,3,4,56,789]");
        int[] ints = head.toArray();

        assertEquals(head.length(), ints.length);
        assertEquals(1, ints[0]);
        assertEquals(789, ints[ints.length - 1]);
    }
}