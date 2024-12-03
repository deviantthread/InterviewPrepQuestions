package com.john.leetcode.template.q900_999;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question918Test {
    private final Question918 classUnderTest = new Question918();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[1,-2,3,-2]");
        int expected = 3;
        //    Explanation: Subarray [3] has maximum sum 3.
        Assert.assertEquals(expected, classUnderTest.maxSubarraySumCircular(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[5,-3,5]");
        int expected = 10;
        //    Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
        Assert.assertEquals(expected, classUnderTest.maxSubarraySumCircular(nums));
    }

    @Test
    public void testExample3() {
        int[] nums = CollectionCreator.createArrayInt("[-3,-2,-3]");
        int expected = -2;
        //    Explanation: Subarray [-2] has maximum sum -2.
        Assert.assertEquals(expected, classUnderTest.maxSubarraySumCircular(nums));
    }

    @Test
    public void testExample4() {
        int[] nums = CollectionCreator.createArrayInt("[3,1,3,2,6]");
        int expected = 15;
        //    Explanation: Subarray [-2] has maximum sum -2.
        Assert.assertEquals(expected, classUnderTest.maxSubarraySumCircular(nums));
    }
}
