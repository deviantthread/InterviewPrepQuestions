package com.john.leetcode.Dec2024.q100_199;

import org.junit.Assert;
import org.junit.Test;

public class Question136Test {
    private Question136 classUnderTest = new Question136();

    @Test
    public void testExample1() {
        int[] nums = { 2, 2, 1 };
        int expected = 1;
        Assert.assertEquals(expected, classUnderTest.singleNumber(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = { 4, 1, 2, 1, 2 };
        int expected = 4;
        Assert.assertEquals(expected, classUnderTest.singleNumber(nums));
    }

    @Test
    public void testExample3() {
        int[] nums = { 1 };
        int expected = 1;
        Assert.assertEquals(expected, classUnderTest.singleNumber(nums));
    }
}
