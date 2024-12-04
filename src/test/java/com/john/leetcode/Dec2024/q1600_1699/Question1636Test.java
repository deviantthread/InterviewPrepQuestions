package com.john.leetcode.Dec2024.q1600_1699;

import org.junit.Assert;
import org.junit.Test;

public class Question1636Test {
    private final Question1636 classUnderTest = new Question1636();

    @Test
    public void testExample1() {
        int[] nums = new int[] { 1, 1, 2, 2, 2, 3 };
        int[] expected = new int[] { 3, 1, 1, 2, 2, 2 };
        Assert.assertEquals(expected, classUnderTest.frequencySort(nums));
        //    Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
    }

    @Test
    public void testExample2() {
        int[] nums = new int[] { 2, 3, 1, 3, 2 };
        int[] expected = new int[] { 1, 3, 3, 2, 2 };
        Assert.assertEquals(expected, classUnderTest.frequencySort(nums));
        //    Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
    }

    @Test
    public void testExample3() {
        int[] nums = new int[] { -1, 1, -6, 4, 5, -6, 1, 4, 1 };
        int[] expected = new int[] { 5, -1, 4, 4, -6, -6, 1, 1, 1 };
        Assert.assertEquals(expected, classUnderTest.frequencySort(nums));
    }
}
