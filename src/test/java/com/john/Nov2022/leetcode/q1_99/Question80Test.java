package com.john.Nov2022.leetcode.q1_99;

import com.john.leetcode.inputhelp.CollectionCreator;
import com.john.utils.ArrayAssert;
import org.junit.Assert;
import org.junit.Test;

public class Question80Test {
    private Question80 classUnderTest = new Question80();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[1,1,1,2,2,3]");
        int expectedK = 5;
        int[] expectedNums = CollectionCreator.createArrayInt("[1,1,2,2,3,0]");
        Assert.assertEquals(expectedK, classUnderTest.removeDuplicates(nums));
        ArrayAssert.assertFirstKElementsEqual(expectedNums, nums, expectedK);
        //    Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
        //    It does not matter what you leave beyond the returned k (hence they are underscores).
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[0,0,1,1,1,1,2,3,3]");
        int expectedK = 7;
        int[] expectedNums = CollectionCreator.createArrayInt("[0,0,1,1,2,3,3,0,0]");
        Assert.assertEquals(expectedK, classUnderTest.removeDuplicates(nums));
        ArrayAssert.assertFirstKElementsEqual(expectedNums, nums, expectedK);
        //    Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
        //    It does not matter what you leave beyond the returned k (hence they are underscores).
    }
}
