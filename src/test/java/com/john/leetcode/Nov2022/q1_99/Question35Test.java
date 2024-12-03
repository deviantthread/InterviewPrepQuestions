package com.john.leetcode.Nov2022.q1_99;

import org.junit.Assert;
import org.junit.Test;

public class Question35Test {
    private Question35 classUnderTest = new Question35();

    @Test
    public void testExample1() {
        int[] nums = { 1, 3, 5, 6 };
        int target = 5;
        int expected = 2;

        Assert.assertEquals(expected, classUnderTest.searchInsert(nums, target));
    }

    @Test
    public void testExample2() {
        int[] nums = { 1, 3, 5, 6 };
        int target = 2;
        int expected = 1;

        Assert.assertEquals(expected, classUnderTest.searchInsert(nums, target));
    }

    @Test
    public void testExample3() {
        int[] nums = { 1, 3, 5, 6 };
        int target = 7;
        int expected = 4;

        Assert.assertEquals(expected, classUnderTest.searchInsert(nums, target));
    }

    @Test
    public void testExample4() {
        int[] nums = { 1, 3, 5, 6 };
        int target = 0;
        int expected = 0;

        Assert.assertEquals(expected, classUnderTest.searchInsert(nums, target));
    }

    @Test
    public void testExample5() {
        int[] nums = { 1 };
        int target = 1;
        int expected = 0;

        Assert.assertEquals(expected, classUnderTest.searchInsert(nums, target));
    }

    @Test
    public void testExample6() {
        int[] nums = { 1,3 };
        int target = 2;
        int expected = 1;

        Assert.assertEquals(expected, classUnderTest.searchInsert(nums, target));
    }
}