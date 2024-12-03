package com.john.leetcode.Nov2022.q1_99;

import com.john.leetcode.Nov2022.q1_99.Question66;
import org.junit.Assert;
import org.junit.Test;

public class Question66Test {
    private final Question66 classUnderTest = new Question66();

    @Test
    public void testExample1() {

        int[] digits = { 1, 2, 3 };
        int[] expected = { 1, 2, 4 };
        //    Explanation: The array represents the integer 123.
        //    Incrementing by one gives 123 + 1 = 124.
        //    Thus, the result should be [1,2,4].
        Assert.assertArrayEquals(expected, classUnderTest.plusOne(digits));
    }

    @Test
    public void testExample2() {

        int[] digits = { 4, 3, 2, 1 };
        int[] expected = { 4, 3, 2, 2 };
        //    Explanation: The array represents the integer 4321.
        //    Incrementing by one gives 4321 + 1 = 4322.
        //    Thus, the result should be [4,3,2,2].
        Assert.assertArrayEquals(expected, classUnderTest.plusOne(digits));
    }

    @Test
    public void testExample3() {

        int[] digits = { 9 };
        int[] expected = { 1, 0 };
        //    Explanation: The array represents the integer 9.
        //    Incrementing by one gives 9 + 1 = 10.
        //    Thus, the result should be [1,0].
        Assert.assertArrayEquals(expected, classUnderTest.plusOne(digits));
    }
}