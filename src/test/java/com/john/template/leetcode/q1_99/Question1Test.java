package com.john.template.leetcode.q1_99;

import com.john.leetcode.template.q1_99.q1_99.Question1;
import org.junit.Assert;
import org.junit.Test;

public class Question1Test {
    private Question1 classUnderTest = new Question1();

    @Test
    public void testExample1() {

        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] expected = { 0, 1 };

        //    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        Assert.assertArrayEquals(expected, classUnderTest.twoSum(nums, target));
    }

    @Test
    public void testExample2() {

        int[] nums = { 3, 2, 4 };
        int target = 6;
        int[] expected = { 1, 2 };

        Assert.assertArrayEquals(expected, classUnderTest.twoSum(nums, target));
    }

    @Test
    public void testExample3() {

        int[] nums = { 3, 3 };
        int target = 6;
        int[] expected = { 0, 1 };

        Assert.assertArrayEquals(expected, classUnderTest.twoSum(nums, target));
    }
}
