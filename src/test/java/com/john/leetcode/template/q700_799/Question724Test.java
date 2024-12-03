package com.john.leetcode.template.q700_799;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question724Test {
    private final Question724 classUnderTest = new Question724();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[1,7,3,6,5,6]");
        int expected = 3;
        Assert.assertEquals(expected, classUnderTest.pivotIndex(nums));
        //    Explanation:
        //    The pivot index is 3.
        //    Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
        //    Right sum = nums[4] + nums[5] = 5 + 6 = 11
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[1,2,3]");
        int expected = -1;
        Assert.assertEquals(expected, classUnderTest.pivotIndex(nums));
        //    Explanation:
        //    There is no index that satisfies the conditions in the problem statement.
    }

    @Test
    public void testExample3() {
        int[] nums = CollectionCreator.createArrayInt("[2,1,-1]");
        int expected = 0;
        Assert.assertEquals(expected, classUnderTest.pivotIndex(nums));
        //    Explanation:
        //    The pivot index is 0.
        //    Left sum = 0 (no elements to the left of index 0)
        //    Right sum = nums[1] + nums[2] = 1 + -1 = 0
    }
}
