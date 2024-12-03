package com.john.Nov2022.leetcode.q1_99;

import com.john.leetcode.inputhelp.CollectionCreator;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class Question31Test {
    private Question31 classUnderTest = new Question31();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[1,2,3]");
        int[] expected = CollectionCreator.createArrayInt("[1,3,2]");
        classUnderTest.nextPermutation(nums);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[3,2,1]");
        int[] expected = CollectionCreator.createArrayInt("[1,2,3]");
        classUnderTest.nextPermutation(nums);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(nums));
    }

    @Test
    public void testExample3() {
        int[] nums = CollectionCreator.createArrayInt("[1,1,5]");
        int[] expected = CollectionCreator.createArrayInt("[1,5,1]");
        classUnderTest.nextPermutation(nums);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(nums));
    }

    @Test
    public void testExample4() {
        int[] nums = CollectionCreator.createArrayInt("[2,9,3]");
        int[] expected = CollectionCreator.createArrayInt("[3,2,9]");
        classUnderTest.nextPermutation(nums);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(nums));
    }

    @Test
    public void testExample5() {
        int[] nums = CollectionCreator.createArrayInt("[2,3,1]");
        int[] expected = CollectionCreator.createArrayInt("[3,1,2]");
        classUnderTest.nextPermutation(nums);
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(nums));
    }
}
