package com.john.Nov2022.leetcode.q1_99;

import com.john.leetcode.inputhelp.CollectionCreator;
import com.john.utils.ListAssert;
import java.util.List;
import org.junit.Test;

public class Question78Test {
    private Question78 classUnderTest = new Question78();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[1,2,3]");
        List<List<Integer>> expected = CollectionCreator.createListListInt("[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]");
        List<List<Integer>> actual = classUnderTest.subsets(nums);
        ListAssert.assertSortedListEquals(expected, actual, (l1, l2) -> {
            if (l1.size() != l2.size()) {
                return Integer.compare(l1.size(), l2.size());
            } else {
                return Integer.compare(l1.stream().reduce(0, Integer::sum), l2.stream().reduce(0, Integer::sum));
            }
        });
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[0]");
        List<List<Integer>> expected = CollectionCreator.createListListInt("[[],[0]]");
        ListAssert.assertListEquals(expected, classUnderTest.subsets(nums));
    }
}
