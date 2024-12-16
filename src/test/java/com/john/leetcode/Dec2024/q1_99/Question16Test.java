package com.john.leetcode.Dec2024.q1_99;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class Question16Test {
    private Question16 classUnderTest = new Question16();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[-1,2,1,-4]");
        int target = 1;
        int expected = 2;
        //    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
        Assert.assertEquals(expected, classUnderTest.threeSumClosest(nums, target));
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[0,0,0]");
        int target = 1;
        int expected = 0;
        //    Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
        Assert.assertEquals(expected, classUnderTest.threeSumClosest(nums, target));
    }
}
