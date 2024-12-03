package com.john.leetcode.Dec2024.q800_899;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question875Test {
    private final Question875 classUnderTest = new Question875();

    @Test
    public void testExample1() {
        int[] piles = CollectionCreator.createArrayInt("[3,6,7,11]");
        int h = 8;
        int expected = 4;

        Assert.assertEquals(expected, classUnderTest.minEatingSpeed(piles, h));
    }

    @Test
    public void testExample2() {
        int[] piles = CollectionCreator.createArrayInt("[30,11,23,4,20]");
        int h = 5;
        int expected = 30;

        Assert.assertEquals(expected, classUnderTest.minEatingSpeed(piles, h));
    }

    @Test
    public void testExample3() {
        int[] piles = CollectionCreator.createArrayInt("[30,11,23,4,20]");
        int h = 6;
        int expected = 23;

        Assert.assertEquals(expected, classUnderTest.minEatingSpeed(piles, h));
    }

    @Test
    public void testExample4() {
        int[] piles = CollectionCreator.createArrayInt("[312884470]");
        int h = 312884469;
        int expected = 2;

        Assert.assertEquals(expected, classUnderTest.minEatingSpeed(piles, h));
    }
}
