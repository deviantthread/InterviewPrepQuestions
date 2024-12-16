package com.john.leetcode.Dec2024.q1_99;

import com.john.utils.CollectionCreator;
import java.util.stream.IntStream;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class Question1Test {

    Question1 classUnderTest = new Question1();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[2,7,11,15]");
        int target = 9;
        int[] expected = CollectionCreator.createArrayInt("[0,1]");
        //    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        Assert.assertArrayEquals(expected, classUnderTest.twoSum(nums, target));
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[3,2,4]");
        int target = 6;
        int[] expected = CollectionCreator.createArrayInt("[1,2]");
        Assert.assertArrayEquals(expected, classUnderTest.twoSum(nums, target));
    }

    @Test
    public void testExample3() {
        int[] nums = CollectionCreator.createArrayInt("[3,3]");
        int target = 6;
        int[] expected = CollectionCreator.createArrayInt("[0,1]");
        Assert.assertArrayEquals(expected, classUnderTest.twoSum(nums, target));
    }

    @Test
    public void testTwoSumBasic() {
        int[] nums = IntStream.range(0, 10).toArray();
        int target = 17;

        testTwoSumBase(nums, target);
    }

    @Test
    public void testTwoSumBasicShuffle() {
        int[] nums = IntStream.range(0, 10).toArray();
        ArrayUtils.shuffle(nums);
        int target = 17;

        testTwoSumBase(nums, target);
    }

    @Test
    public void testTwoSumReusedIndex() {
        int[] nums = { 3, 3 };
        int target = 6;

        testTwoSumBase(nums, target);
    }

    private void testTwoSumBase(int[] nums, int target) {
        int[] hashResult = classUnderTest.twoSum(nums, target);

        verifyCorrect(nums, hashResult, target);
    }

    private void verifyCorrect(int[] nums, int[] ret, int target) {
        Assert.assertEquals(ret.length, 2);
        Assert.assertNotEquals(ret[0], ret[1]);
        Assert.assertEquals(nums[ret[0]] + nums[ret[1]], target);
    }
}