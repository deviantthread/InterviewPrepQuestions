package com.john.leetcode.Dec2024.q1_99;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question53Test {
    private Question53 classUnderTest = new Question53();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[-2,1,-3,4,-1,2,1,-5,4]");
        int expected = 6;
        //    Explanation: The subarray [4,-1,2,1] has the largest sum 6.
        Assert.assertEquals(expected, classUnderTest.maxSubArray(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[1]");
        int expected = 1;
        //    Explanation: The subarray [1] has the largest sum 1.
        Assert.assertEquals(expected, classUnderTest.maxSubArray(nums));
    }

    @Test
    public void testExample3() {
        int[] nums = CollectionCreator.createArrayInt("[5,4,-1,7,8]");
        int expected = 23;
        //    Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
        Assert.assertEquals(expected, classUnderTest.maxSubArray(nums));
    }
}
