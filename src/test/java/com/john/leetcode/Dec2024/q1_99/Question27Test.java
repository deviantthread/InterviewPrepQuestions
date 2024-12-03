package com.john.leetcode.Dec2024.q1_99;

import com.john.utils.ArrayAssert;
import org.junit.Assert;
import org.junit.Test;

public class Question27Test {
    private final Question27 classUnderTest = new Question27();

    @Test
    public void testExample1() {

        int[] nums = { 3, 2, 2, 3 };
        int val = 3;
        int expected = 2;
        int[] expectedNums = { 2, 2, -1, -1 };
        //    Explanation: Your function should return k = 2, with the first two elements of nums being 2.
        //    It does not matter what you leave beyond the returned k (hence they are underscores).
        Assert.assertEquals(expected, classUnderTest.removeElement(nums, val));
        ArrayAssert.assertFirstKElementsEqual(nums, expectedNums, expected);
    }

    @Test
    public void testExample2() {
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val = 2;
        int expected = 5;
        int[] expectedNums = { 0, 1, 3, 0, 4, -1, -1, -1 };
        //    Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
        //    Note that the five elements can be returned in any order.
        //    It does not matter what you leave beyond the returned k (hence they are underscores).
        Assert.assertEquals(expected, classUnderTest.removeElement(nums, val));
        ArrayAssert.assertFirstKElementsEqual(nums, expectedNums, expected);
    }
}