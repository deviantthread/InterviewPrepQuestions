package com.john.leetcode.Nov2022.q500_599;

import org.junit.Assert;
import org.junit.Test;

public class Question509Test {
    private final Question509 classUnderTest = new Question509();

    @Test
    public void testExample1() {
        int n = 2;
        int expected = 1;
        //    Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
        Assert.assertEquals(expected, classUnderTest.fib(n));
    }

    @Test
    public void testExample2() {
        int n = 3;
        int expected = 2;
        //    Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
        Assert.assertEquals(expected, classUnderTest.fib(n));
    }

    @Test
    public void testExample3() {
        int n = 4;
        int expected = 3;
        //    Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
        Assert.assertEquals(expected, classUnderTest.fib(n));
    }
}
