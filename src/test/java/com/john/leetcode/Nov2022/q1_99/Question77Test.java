package com.john.leetcode.Nov2022.q1_99;

import com.john.utils.CollectionCreator;
import com.john.utils.ListAssert;
import java.util.List;
import org.junit.Test;

public class Question77Test {
    private Question77 classUnderTest = new Question77();

    @Test
    public void testExample1() {
        int n = 4;
        int k = 2;
        List<List<Integer>> expected = CollectionCreator.createListListInt("[[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]");
        List<List<Integer>> actual = classUnderTest.combine(n, k);
        ListAssert.assertListEquals(expected, actual);
        //    Explanation: There are 4 choose 2 = 6 total combinations.
        //    Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
    }

    @Test
    public void testExample2() {
        int n = 1;
        int k = 1;
        List<List<Integer>> expected = CollectionCreator.createListListInt("[[1]]");
        ListAssert.assertListEquals(expected, classUnderTest.combine(n, k));
        //    Explanation: There is 1 choose 1 = 1 total combination.
    }
}
