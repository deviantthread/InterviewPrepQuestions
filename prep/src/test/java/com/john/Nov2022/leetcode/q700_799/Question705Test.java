package com.john.Nov2022.leetcode.q700_799;

import static com.john.leetcode.inputhelp.CollectionCreator.createArrayInt;

import com.john.Nov2022.leetcode.q700_799.Question705.MyHashSet;
import com.john.leetcode.inputhelp.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question705Test {
    private final Question705 classUnderTest = new Question705();

    @Test
    public void testExample1() {

        //        Input
        //            ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
        //[[], [1], [2], [1], [3], [2], [2], [2], [2]]
        //        Output
        //            [null, null, null, true, false, null, true, null, false]

        //        Explanation
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        Assert.assertArrayEquals(createArrayInt("[1]"), myHashSet.toAry());
        myHashSet.add(2);      // set = [1, 2]
        Assert.assertArrayEquals(createArrayInt("[1,2]"), myHashSet.toAry());
        Assert.assertTrue(myHashSet.contains(1)); // return True
        Assert.assertFalse(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        Assert.assertArrayEquals(createArrayInt("[1,2]"), myHashSet.toAry());
        Assert.assertTrue(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        Assert.assertArrayEquals(createArrayInt("[1]"), myHashSet.toAry());
        Assert.assertFalse(myHashSet.contains(2)); // return False, (already removed)    }
    }
}