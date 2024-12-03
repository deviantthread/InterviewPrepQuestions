package com.john.leetcode.Nov2022.q1_99;

import com.google.common.collect.Lists;
import com.john.utils.ListAssert;
import java.util.List;
import org.junit.Test;

public class Question39Test {
    private Question39 classUnderTest = new Question39();

    @Test
    public void testExample1() {

        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> expected = Lists.newArrayList(Lists.newArrayList(2, 2, 3), Lists.newArrayList(7));

        ListAssert.assertListEquals(expected, classUnderTest.combinationSum(candidates, target));
        // Explanation:
        //     2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
        //     7 is a candidate, and 7 = 7.
        // These are the only two combinations.
    }

    @Test
    public void testExample2() {

        int[] candidates = { 2, 3, 5 };
        int target = 8;
        List<List<Integer>> expected = Lists.newArrayList(Lists.newArrayList(2, 2, 2, 2), Lists.newArrayList(2, 3, 3), Lists.newArrayList(3, 5));

        ListAssert.assertListEquals(expected, classUnderTest.combinationSum(candidates, target));
    }

    @Test
    public void testExample3() {

        int[] candidates = { 2 };
        int target = 1;
        List<List<Integer>> expected = Lists.newArrayList();

        ListAssert.assertListEquals(expected, classUnderTest.combinationSum(candidates, target));
    }
}
