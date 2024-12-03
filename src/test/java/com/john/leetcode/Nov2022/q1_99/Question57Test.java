package com.john.leetcode.Nov2022.q1_99;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question57Test {
    private Question57 classUnderTest = new Question57();

    @Test
    public void testExample1() {
        int[][] intervals = CollectionCreator.create2DArrayInt("[[1,3],[6,9]]");
        int[] newInterval = CollectionCreator.createArrayInt("[2,5]");
        int[][] expected = CollectionCreator.create2DArrayInt("[[1,5],[6,9]]");

        Assert.assertArrayEquals(expected, classUnderTest.insert(intervals, newInterval));
    }

    @Test
    public void testExample2() {
        int[][] intervals = CollectionCreator.create2DArrayInt("[[1,2],[3,5],[6,7],[8,10],[12,16]]");
        int[] newInterval = CollectionCreator.createArrayInt("[4,8]");
        int[][] expected = CollectionCreator.create2DArrayInt("[[1,2],[3,10],[12,16]]");
        //    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

        Assert.assertArrayEquals(expected, classUnderTest.insert(intervals, newInterval));
    }
}
