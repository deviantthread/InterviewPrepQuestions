package com.john.Nov2022.leetcode.q300_399;

import com.john.Nov2022.leetcode.q300_399.Question303.NumArray;
import com.john.leetcode.inputhelp.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question303Test {
    private final Question303 classUnderTest = new Question303();

    @Test
    public void testExample1() {
        //        Input
        //            ["NumArray", "sumRange", "sumRange", "sumRange"]
        //[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
        //        Output
        //            [null, 1, -1, -3]

        NumArray numArray = new NumArray(CollectionCreator.createArrayInt("[-2, 0, 3, -5, 2, -1]"));
        Assert.assertEquals(1, numArray.sumRange(0, 2)); // return (-2) + 0 + 3 = 1
        Assert.assertEquals(-1, numArray.sumRange(2, 5)); // return 3 + (-5) + 2 + (-1) = -1
        Assert.assertEquals(-3, numArray.sumRange(0, 5)); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
    }
}
