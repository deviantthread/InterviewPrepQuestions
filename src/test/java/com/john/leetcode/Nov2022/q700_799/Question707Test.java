package com.john.leetcode.Nov2022.q700_799;

import static com.john.utils.CollectionCreator.createArrayInt;

import com.john.leetcode.Nov2022.q700_799.Question707.MyLinkedList;
import org.junit.Assert;
import org.junit.Test;

public class Question707Test {
    private final Question707 classUnderTest = new Question707();

    @Test
    public void testExample1() {

        //        Input
        //            ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
        //    [[], [1], [3], [1, 2], [1], [1], [1]]
        //        Output
        //            [null, null, null, null, 2, null, 3]

        //        Explanation
        MyLinkedList myLinkedList = new MyLinkedList();
        Assert.assertArrayEquals(createArrayInt("[]"), myLinkedList.toArray());
        myLinkedList.addAtHead(1);
        Assert.assertArrayEquals(createArrayInt("[1]"), myLinkedList.toArray());
        myLinkedList.addAtTail(3);
        Assert.assertArrayEquals(createArrayInt("[1,3]"), myLinkedList.toArray());
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        Assert.assertArrayEquals(createArrayInt("[1,2,3]"), myLinkedList.toArray());
        Assert.assertEquals(2, myLinkedList.get(1));              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        Assert.assertArrayEquals(createArrayInt("[1,3]"), myLinkedList.toArray());
        Assert.assertEquals(3, myLinkedList.get(1));              // return 3
    }
}
