package com.john.leetcode.template.q100_199;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question198Test {
    private Question198 classUnderTest = new Question198();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[1,2,3,1]");
        int expected = 4;
        //    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
        //    Total amount you can rob = 1 + 3 = 4.
        Assert.assertEquals(expected, classUnderTest.rob(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[2,7,9,3,1]");
        int expected = 12;
        //    Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
        //    Total amount you can rob = 2 + 9 + 1 = 12.
        Assert.assertEquals(expected, classUnderTest.rob(nums));
    }
}
