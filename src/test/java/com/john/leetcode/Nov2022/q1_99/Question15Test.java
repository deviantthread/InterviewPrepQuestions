package com.john.leetcode.Nov2022.q1_99;

import com.john.utils.CollectionCreator;
import com.john.utils.CollectionSorter;
import com.john.utils.ListAssert;
import java.util.List;
import org.junit.Test;

public class Question15Test {
    private Question15 classUnderTest = new Question15();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[-1,0,1,2,-1,-4]");
        List<List<Integer>> expected = CollectionCreator.createListListInt("[[-1,-1,2],[-1,0,1]]");
        //    Explanation:
        //    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        //    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        //    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        //    The distinct triplets are [-1,0,1] and [-1,-1,2].
        //    Notice that the order of the output and the order of the triplets does not matter.
        List<List<Integer>> actual = classUnderTest.threeSum(nums);

        CollectionSorter.sortListListInt(expected);
        CollectionSorter.sortListListInt(actual);

        ListAssert.assertListEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[0,1,1]");
        List<List<Integer>> expected = CollectionCreator.createListListInt("[]");
        //    Explanation: The only possible triplet does not sum up to 0.
        List<List<Integer>> actual = classUnderTest.threeSum(nums);
        CollectionSorter.sortListListInt(expected);
        CollectionSorter.sortListListInt(actual);

        ListAssert.assertListEquals(expected, actual);
    }

    @Test
    public void testExample3() {
        int[] nums = CollectionCreator.createArrayInt("[0,0,0]");
        List<List<Integer>> expected = CollectionCreator.createListListInt("[[0,0,0]]");
        //    Explanation: The only possible triplet sums up to 0.
        List<List<Integer>> actual = classUnderTest.threeSum(nums);

        CollectionSorter.sortListListInt(expected);
        CollectionSorter.sortListListInt(actual);

        ListAssert.assertListEquals(expected, actual);
    }
}
