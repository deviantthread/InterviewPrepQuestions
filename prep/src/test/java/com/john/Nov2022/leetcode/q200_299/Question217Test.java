package com.john.Nov2022.leetcode.q200_299;

import com.john.leetcode.inputhelp.CollectionCreator;
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