package com.john.leetcode.template.q200_299;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question209Test {
    private final Question209 classUnderTest = new Question209();

    @Test
    public void testExample1() {
        int target = 7;
        int[] nums = CollectionCreator.createArrayInt("[2,3,1,2,4,3]");
        int expected = 2;
        Assert.assertEquals(expected, classUnderTest.minSubArrayLen(target, nums));
        //    Explanation: The subarray [4,3] has the minimal length under the problem constraint.
    }

    @Test
    public void testExample2() {
        int target = 4;
        int[] nums = CollectionCreator.createArrayInt("[1,4,4]");
        int expected = 1;
        Assert.assertEquals(expected, classUnderTest.minSubArrayLen(target, nums));
    }

    @Test
    public void testExample3() {
        int target = 11;
        int[] nums = CollectionCreator.createArrayInt("[1,1,1,1,1,1,1,1]");
        int expected = 0;
        Assert.assertEquals(expected, classUnderTest.minSubArrayLen(target, nums));
    }
}
