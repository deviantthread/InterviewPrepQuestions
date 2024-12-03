package com.john.leetcode.Nov2022.q1_99;

import java.util.stream.IntStream;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class Question1Test {

    Question1 question1 = new Question1();

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
        int[] hashResult = question1.twoSumHashMap(nums, target);

        verifyCorrect(nums, hashResult, target);

        int[] binaryResult = question1.twoSumBinarySearch(nums, target);

        verifyCorrect(nums, binaryResult, target);
    }

    private void verifyCorrect(int[] nums, int[] ret, int target) {
        Assert.assertEquals(ret.length, 2);
        Assert.assertNotEquals(ret[0], ret[1]);
        Assert.assertEquals(nums[ret[0]] + nums[ret[1]], target);
    }
}