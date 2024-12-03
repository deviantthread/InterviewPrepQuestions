package com.john.leetcode.Nov2022.q200_299;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question238Test {
    private final Question238 classUnderTest = new Question238();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[1,2,3,4]");
        int[] expected = CollectionCreator.createArrayInt("[24,12,8,6]");
        Assert.assertArrayEquals(expected, classUnderTest.productExceptSelf(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[-1,1,0,-3,3]");
        int[] expected = CollectionCreator.createArrayInt("[0,0,9,0,0]");
        Assert.assertArrayEquals(expected, classUnderTest.productExceptSelf(nums));
    }
}
