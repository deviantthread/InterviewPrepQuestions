package com.john.leetcode.template.q1_99;

import org.junit.Assert;
import org.junit.Test;

public class Question62Test {
    private Question62 classUnderTest = new Question62();

    @Test
    public void testExample1() {
        int m = 3;
        int n = 7;
        int expected = 28;
        Assert.assertEquals(expected, classUnderTest.uniquePaths(m, n));
    }

    @Test
    public void testExample2() {
        int m = 3;
        int n = 2;
        int expected = 3;
        Assert.assertEquals(expected, classUnderTest.uniquePaths(m, n));
        //    Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
        //1. Right -> Down -> Down
        //2. Down -> Down -> Right
        //3. Down -> Right -> Down
    }
}
