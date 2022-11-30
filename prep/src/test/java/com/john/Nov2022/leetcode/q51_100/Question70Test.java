package com.john.Nov2022.leetcode.q51_100;

import org.junit.Assert;
import org.junit.Test;

public class Question70Test {
    private final Question70 classUnderTest = new Question70();

    @Test
    public void testExample1() {
        int n = 2;
        int expected = 2;
        //    Explanation: There are two ways to climb to the top.
        //1. 1 step + 1 step
        //2. 2 steps
        Assert.assertEquals(expected, classUnderTest.climbStairs(n));
    }

    @Test
    public void testExample2() {
        int n = 3;
        int expected = 3;
        //    Explanation: There are three ways to climb to the top.
        //1. 1 step + 1 step + 1 step
        //2. 1 step + 2 steps
        //3. 2 steps + 1 step
        Assert.assertEquals(expected, classUnderTest.climbStairs(n));
    }

    @Test
    public void testExample3() {
        int n = 44;
        int expected = 1134903170;
        //    Explanation: There are three ways to climb to the top.
        //1. 1 step + 1 step + 1 step
        //2. 1 step + 2 steps
        //3. 2 steps + 1 step
        Assert.assertEquals(expected, classUnderTest.climbStairs(n));
    }
}