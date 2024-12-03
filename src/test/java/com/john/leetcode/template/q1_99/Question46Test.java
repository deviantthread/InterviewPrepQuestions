package com.john.leetcode.template.q1_99;

import static com.john.utils.ListAssert.LIST_INT_COMPARATOR;

import com.john.utils.CollectionCreator;
import com.john.utils.ListAssert;
import java.util.List;
import org.junit.Test;

public class Question46Test {
    private Question46 classUnderTest = new Question46();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[1,2,3]");
        List<List<Integer>> expected = CollectionCreator.createListListInt("[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]");
        ListAssert.assertSortedListEquals(expected, classUnderTest.permute(nums), LIST_INT_COMPARATOR);
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[0,1]");
        List<List<Integer>> expected = CollectionCreator.createListListInt("[[0,1],[1,0]]");
        ListAssert.assertSortedListEquals(expected, classUnderTest.permute(nums), LIST_INT_COMPARATOR);
    }

    @Test
    public void testExample3() {
        int[] nums = CollectionCreator.createArrayInt("[1]");
        List<List<Integer>> expected = CollectionCreator.createListListInt("[[1]]");
        ListAssert.assertSortedListEquals(expected, classUnderTest.permute(nums), LIST_INT_COMPARATOR);
    }
}
