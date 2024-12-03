package com.john.leetcode.Nov2022.q200_299;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question287Test {
    private final Question287 classUnderTest = new Question287();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[1,3,4,2,2]");
        int expected = 2;
        Assert.assertEquals(expected, classUnderTest.findDuplicate(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[3,1,3,4,2]");
        int expected = 3;
        Assert.assertEquals(expected, classUnderTest.findDuplicate(nums));
    }
}
