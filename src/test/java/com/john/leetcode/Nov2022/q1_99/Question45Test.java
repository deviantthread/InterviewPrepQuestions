package com.john.leetcode.Nov2022.q1_99;

import com.john.leetcode.Nov2022.q1_99.Question45;
import org.junit.Assert;
import org.junit.Test;

public class Question45Test {
    private Question45 classUnderTest = new Question45();

    @Test
    public void testExample1() {
        int[] nums = { 2, 3, 1, 1, 4 };
        int expected = 2;
        Assert.assertEquals(expected, classUnderTest.jump(nums));
        //    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
    }

    @Test
    public void testExample2() {
        int[] nums = { 2, 3, 0, 1, 4 };
        int expected = 2;
        Assert.assertEquals(expected, classUnderTest.jump(nums));
    }
    @Test
    public void testExample3() {
        int[] nums = { 0 };
        int expected = 0;
        Assert.assertEquals(expected, classUnderTest.jump(nums));
    }
}
