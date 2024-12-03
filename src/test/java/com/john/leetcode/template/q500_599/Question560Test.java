package com.john.leetcode.template.q500_599;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question560Test {
    private final Question560 classUnderTest = new Question560();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[1,1,1]");
        int k = 2;
        int expected = 2;
        Assert.assertEquals(expected, classUnderTest.subarraySum(nums, k));
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[1,2,3]");
        int k = 3;
        int expected = 2;
        Assert.assertEquals(expected, classUnderTest.subarraySum(nums, k));
    }
}
