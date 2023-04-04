package com.john.Nov2022.leetcode.q1_99;

import static com.john.utils.ListAssert.LIST_INT_COMPARATOR;

import com.john.leetcode.inputhelp.CollectionCreator;
import com.john.utils.ListAssert;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class Question90Test {
    private Question90 classUnderTest = new Question90();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[1,2,2]");
        List<List<Integer>> expected = CollectionCreator.createListListInt("[[],[1],[1,2],[1,2,2],[2],[2,2]]");
        List<List<Integer>> actual = classUnderTest.subsetsWithDup(nums);
        ListAssert.assertSortedListEquals(expected, actual, LIST_INT_COMPARATOR);
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[0]");
        List<List<Integer>> expected = CollectionCreator.createListListInt("[[],[0]]");
        List<List<Integer>> actual = classUnderTest.subsetsWithDup(nums);
        ListAssert.assertSortedListEquals(expected, actual, LIST_INT_COMPARATOR);
    }
}
