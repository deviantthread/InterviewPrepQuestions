package com.john.leetcode.template.q1_99;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question56Test {
    private Question56 classUnderTest = new Question56();

    @Test
    public void testExample1() {

        int[][] intervals = CollectionCreator.create2DArrayInt("[[1,3],[2,6],[8,10],[15,18]]");
        int[][] output = CollectionCreator.create2DArrayInt("[[1,6],[8,10],[15,18]]");
        //    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
        Assert.assertArrayEquals(output, classUnderTest.merge(intervals));
    }

    @Test
    public void testExample2() {
        int[][] intervals = CollectionCreator.create2DArrayInt("[[1,4],[4,5]]");
        int[][] output = CollectionCreator.create2DArrayInt("[[1,5]]");
        //    Explanation: Intervals [1,4] and [4,5] are considered overlapping.}
        Assert.assertArrayEquals(output, classUnderTest.merge(intervals));
    }
}