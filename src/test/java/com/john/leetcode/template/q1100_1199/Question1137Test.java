package com.john.leetcode.template.q1100_1199;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class Question1137Test {
    private final Question1137 classUnderTest = new Question1137();

    @Test
    public void testExample1() {
        int n = 4;
        int expected = 4;
        Assert.assertEquals(expected, classUnderTest.tribonacci(n));
        //    Explanation:
        //    T_3 = 0 + 1 + 1 = 2
        //    T_4 = 1 + 1 + 2 = 4
    }

    @Test
    public void testExample2() {
        int n = 25;
        int expected = 1389537;
        Assert.assertEquals(expected, classUnderTest.tribonacci(n));
    }

    @Test
    public void testExample3() {
        int n = 1;
        int expected = 1;
        Assert.assertEquals(expected, classUnderTest.tribonacci(n));
    }

    @Test(timeout = 500)
    public void testExample4() {
        int n = 35;
        int expected = 615693474;
        Assert.assertEquals(expected, classUnderTest.tribonacci(n));
    }
}
