package com.john.leetcode.Dec2024.q100_199;

import com.john.leetcode.Dec2024.q100_199.Question155.MinStack;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class Question155Test {
    private Question155 classUnderTest = new Question155();


    @Test
    public void testExample1() {
        //        Input
        //            ["MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"]
        //    [[],[-2],[0],[-3],[],[],[],[]]
        //
        //        Output
        //            [null, null, null, null, -3, null, 0, -2]

        //        Explanation
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assert.assertEquals(-3, minStack.top());
        Assert.assertEquals(-3, minStack.getMin()); // return -3
        minStack.push(1);
        Assert.assertEquals(1, minStack.top());
        Assert.assertEquals(-3, minStack.getMin()); // return -3
        minStack.pop();
        minStack.pop();
        Assert.assertEquals(0, minStack.top());    // return 0
        Assert.assertEquals(-2, minStack.getMin()); // return -2
        minStack.pop();
        Assert.assertEquals(-2, minStack.top());    // return 0
    }
}
