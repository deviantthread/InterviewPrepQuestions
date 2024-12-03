package com.john.leetcode.Nov2022.q300_399;

import org.junit.Assert;
import org.junit.Test;

public class Question374Test {
    @Test
    public void testExample1() {
        int n = 10;
        int pick = 6;
        int expected = 6;
        Assert.assertEquals(expected, new Question374(pick).guessNumber(n));
    }

    @Test
    public void testExample2() {
        int n = 1;
        int pick = 1;
        int expected = 1;
        Assert.assertEquals(expected, new Question374(pick).guessNumber(n));
    }

    @Test
    public void testExample3() {
        int n = 2;
        int pick = 1;
        int expected = 1;
        Assert.assertEquals(expected, new Question374(pick).guessNumber(n));
    }
}
