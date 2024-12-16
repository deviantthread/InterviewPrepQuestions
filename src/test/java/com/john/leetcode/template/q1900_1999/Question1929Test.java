package com.john.leetcode.template.q1900_1999;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class Question1929Test {
    private final Question1929 classUnderTest = new Question1929();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[1,2,1]");
        int[] expected = CollectionCreator.createArrayInt("[1,2,1,1,2,1]");
        Assert.assertArrayEquals(expected, classUnderTest.getConcatenation(nums));
        //    Explanation: The array ans is formed as follows:
        //        - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
        //        - ans = [1,2,1,1,2,1]
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[1,3,2,1]");
        int[] expected = CollectionCreator.createArrayInt("[1,3,2,1,1,3,2,1]");
        Assert.assertArrayEquals(expected, classUnderTest.getConcatenation(nums));
        //    Explanation: The array ans is formed as follows:
        //        - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
        //        - ans = [1,3,2,1,1,3,2,1]
    }
}
