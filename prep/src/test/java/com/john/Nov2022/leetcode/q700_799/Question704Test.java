package com.john.Nov2022.leetcode.q700_799;

import com.john.leetcode.inputhelp.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question704Test {
    private final Question704 classUnderTest = new Question704();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[-1,0,3,5,9,12]");
        int target = 9;
        int expected = 4;
        //    Explanation: 9 exists in nums and its index is 4
        Assert.assertEquals(expected, classUnderTest.search(nums, target));
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[-1,0,3,5,9,12]");
        int target = 2;
        int expected = -1;
        //    Explanation: 2 does not exist in nums so return -1
        Assert.assertEquals(expected, classUnderTest.search(nums, target));
    }
}
