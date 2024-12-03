package com.john.leetcode.Nov2022.q1_99;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question75Test {
    private Question75 classUnderTest = new Question75();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[2,0,2,1,1,0]");
        int[] expected = CollectionCreator.createArrayInt("[0,0,1,1,2,2]");
        classUnderTest.sortColors(nums);
        Assert.assertArrayEquals(expected, nums);
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[2,0,1]");
        int[] expected = CollectionCreator.createArrayInt("[0,1,2]");
        classUnderTest.sortColors(nums);
        Assert.assertArrayEquals(expected, nums);
    }
}
