package com.john.leetcode.template.q1_99;

import static com.john.utils.ListAssert.LIST_INT_COMPARATOR;

import com.john.utils.CollectionCreator;
import com.john.utils.ListAssert;
import java.util.List;
import org.junit.Test;

public class Question47Test {
    private Question47 classUnderTest = new Question47();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[1,1,2]");
        List<List<Integer>> expected = CollectionCreator.createListListInt("[[1,1,2],[1,2,1],[2,1,1]]");
        ListAssert.assertSortedListEquals(expected, classUnderTest.permuteUnique(nums), LIST_INT_COMPARATOR);
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[1,2,3]");
        List<List<Integer>> expected = CollectionCreator.createListListInt("[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]");
        ListAssert.assertSortedListEquals(expected, classUnderTest.permuteUnique(nums), LIST_INT_COMPARATOR);
    }
}
