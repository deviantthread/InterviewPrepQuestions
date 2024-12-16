package com.john.leetcode.template.q1_99;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class Question33Test {
    private Question33 classUnderTest = new Question33();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[4,5,6,7,0,1,2]");
        int target = 0;
        int expected = 4;
        Assert.assertEquals(expected, classUnderTest.search(nums, target));
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[4,5,6,7,0,1,2]");
        int target = 3;
        int expected = -1;
        Assert.assertEquals(expected, classUnderTest.search(nums, target));
    }

    @Test
    public void testExample3() {
        int[] nums = CollectionCreator.createArrayInt("[1]");
        int target = 0;
        int expected = -1;
        Assert.assertEquals(expected, classUnderTest.search(nums, target));
    }
}
