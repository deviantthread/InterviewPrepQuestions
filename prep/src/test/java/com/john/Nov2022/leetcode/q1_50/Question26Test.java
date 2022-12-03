package com.john.Nov2022.leetcode.q1_50;

import com.john.utils.ArrayAssert;
import org.junit.Assert;
import org.junit.Test;

public class Question26Test {
    private Question26 classUnderTest = new Question26();

    @Test
    public void testExample1() {
        int[] nums = { 1, 1, 2 };
        int expectedResult = 2;
        int[] expectedArray = { 1, 2, -1 };
        //    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
        //    It does not matter what you leave beyond the returned k (hence they are underscores).
        Assert.assertEquals(expectedResult, classUnderTest.removeDuplicates(nums));
        ArrayAssert.assertFirstKElementsEqual(nums, expectedArray, expectedResult);
    }

    @Test
    public void testExample2() {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        int expectedResult = 5;
        int[] expectedArray = { 0, 1, 2, 3, 4, -1, -1, -1, -1, -1 };
        //    Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
        //    It does not matter what you leave beyond the returned k (hence they are underscores).
        Assert.assertEquals(expectedResult, classUnderTest.removeDuplicates(nums));
        ArrayAssert.assertFirstKElementsEqual(nums, expectedArray, expectedResult);
    }
}
