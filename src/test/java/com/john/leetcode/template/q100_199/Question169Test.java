package com.john.leetcode.template.q100_199;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question169Test {
    private Question169 classUnderTest = new Question169();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[3,2,3]");
        int expected = 3;
        Assert.assertEquals(expected, classUnderTest.majorityElement(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[2,2,1,1,1,2,2]");
        int expected = 2;
        Assert.assertEquals(expected, classUnderTest.majorityElement(nums));
    }

    @Test
    public void testExample3() {
        int[] nums = CollectionCreator.createArrayInt("[2]");
        int expected = 2;
        Assert.assertEquals(expected, classUnderTest.majorityElement(nums));
    }


}
