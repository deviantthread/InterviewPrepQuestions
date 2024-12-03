package com.john.leetcode.Nov2022.q200_299;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question217Test {
    private final Question217 classUnderTest = new Question217();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[1,2,3,1]");
        boolean expected = true;
        Assert.assertEquals(expected, classUnderTest.containsDuplicate(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[1,2,3,4]");
        boolean expected = false;
        Assert.assertEquals(expected, classUnderTest.containsDuplicate(nums));
    }

    @Test
    public void testExample3() {
        int[] nums = CollectionCreator.createArrayInt("[1,1,1,3,3,4,3,2,4,2]");
        boolean expected = true;
        Assert.assertEquals(expected, classUnderTest.containsDuplicate(nums));
    }
}