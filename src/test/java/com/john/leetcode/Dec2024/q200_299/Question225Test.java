package com.john.leetcode.Dec2024.q200_299;

import com.google.common.collect.Lists;
import com.john.leetcode.Dec2024.q200_299.Question225.MyStack;
import com.john.utils.ListAssert;
import org.junit.Assert;
import org.junit.Test;

public class Question225Test {
    private final Question225 classUnderTest = new Question225();

    @Test
    public void testExample1() {

        //        Input
        //            ["MyStack", "push", "push", "top", "pop", "empty"]
        //    [[], [1], [2], [], [], []]
        //        Output
        //            [null, null, null, 2, 2, false]

        //        Explanation
        MyStack myStack = new MyStack();
        Assert.assertTrue(myStack.empty());
        ListAssert.assertListEquals(Lists.newArrayList(), myStack.toList());
        myStack.push(1);
        Assert.assertFalse(myStack.empty());
        ListAssert.assertListEquals(Lists.newArrayList(1), myStack.toList());
        myStack.push(2);
        Assert.assertFalse(myStack.empty());
        ListAssert.assertListEquals(Lists.newArrayList(2, 1), myStack.toList());
        Assert.assertEquals(2, myStack.top()); // return 2
        Assert.assertFalse(myStack.empty());
        ListAssert.assertListEquals(Lists.newArrayList(2, 1), myStack.toList());
        Assert.assertEquals(2, myStack.pop()); // return 2
        Assert.assertFalse(myStack.empty());
        ListAssert.assertListEquals(Lists.newArrayList(1), myStack.toList());
        Assert.assertFalse(myStack.empty());
        ListAssert.assertListEquals(Lists.newArrayList(1), myStack.toList());
    }

    @Test
    public void testExample2() {
        MyStack myStack = new MyStack();
        Assert.assertTrue(myStack.empty());
        ListAssert.assertListEquals(Lists.newArrayList(), myStack.toList());
        myStack.push(1);
        Assert.assertFalse(myStack.empty());
        ListAssert.assertListEquals(Lists.newArrayList(1), myStack.toList());
        myStack.push(2);
        Assert.assertFalse(myStack.empty());
        ListAssert.assertListEquals(Lists.newArrayList(2, 1), myStack.toList());
        Assert.assertEquals(2, myStack.pop());// return 2
        Assert.assertFalse(myStack.empty());
        ListAssert.assertListEquals(Lists.newArrayList(1), myStack.toList());
        Assert.assertEquals(1, myStack.top());// return 1
        Assert.assertFalse(myStack.empty());
        ListAssert.assertListEquals(Lists.newArrayList(1), myStack.toList());
        Assert.assertFalse(myStack.empty());
        ListAssert.assertListEquals(Lists.newArrayList(1), myStack.toList());
    }
}