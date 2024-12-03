package com.john.leetcode.Nov2022.q700_799;

import com.john.leetcode.Nov2022.q700_799.Question703.KthLargest;
import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question703Test {
    private final Question703 classUnderTest = new Question703();

    @Test
    public void testExample1() {
        KthLargest kthLargest = new KthLargest(3, CollectionCreator.createArrayInt("[4, 5, 8, 2]"));
        Assert.assertEquals(4, kthLargest.add(3));   // return 4
        Assert.assertEquals(5, kthLargest.add(5));   // return 5
        Assert.assertEquals(5, kthLargest.add(10));  // return 5
        Assert.assertEquals(8, kthLargest.add(9));   // return 8
        Assert.assertEquals(8, kthLargest.add(4));   // return 8
    }
}
