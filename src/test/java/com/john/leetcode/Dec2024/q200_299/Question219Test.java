package com.john.leetcode.Dec2024.q200_299;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question219Test {
    private final Question219 classUnderTest = new Question219();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[1,2,3,1]");
        int k = 3;
        boolean expected = true;
        Assert.assertEquals(expected, classUnderTest.containsNearbyDuplicate(nums, k));
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[1,0,1,1]");
        int k = 1;
        boolean expected = true;
        Assert.assertEquals(expected, classUnderTest.containsNearbyDuplicate(nums, k));
    }

    @Test
    public void testExample3() {
        int[] nums = CollectionCreator.createArrayInt("[1,2,3,1,2,3]");
        int k = 2;
        boolean expected = false;
        Assert.assertEquals(expected, classUnderTest.containsNearbyDuplicate(nums, k));
    }

    @Test
    public void testExample4() {
        int[] nums = CollectionCreator.createArrayInt("[4,1,2,3,1,5]");
        int k = 3;
        boolean expected = true;
        Assert.assertEquals(expected, classUnderTest.containsNearbyDuplicate(nums, k));
    }
}
