package com.john.leetcode.Dec2024.q700_799;

import com.john.leetcode.Nov2022.q700_799.Question706.MyHashMap;
import com.john.utils.MapAssert;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class Question706Test {
    private final Question706 classUnderTest = new Question706();

    @Test
    public void testExample1() {
        //        Input
        //            ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
        //[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
        //        Output
        //            [null, null, null, 1, -1, null, 1, null, -1]
        //
        //        Explanation
        Map<Integer, Integer> expected = new HashMap<>();

        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put(1, 1); // The map is now [[1,1]]
        expected.put(1, 1);
        MapAssert.assertMapEquals(expected, myHashMap.asMap());
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        expected.put(2, 2);
        MapAssert.assertMapEquals(expected, myHashMap.asMap());
        Assert.assertEquals(expected.get(1).intValue(), myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        Assert.assertEquals(-1, myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        expected.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        MapAssert.assertMapEquals(expected, myHashMap.asMap());
        Assert.assertEquals(expected.get(2).intValue(), myHashMap.get(2));    // return 1, The map is now [[1,1], [2,2]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        expected.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        Assert.assertEquals(-1, myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
        MapAssert.assertMapEquals(expected, myHashMap.asMap());
    }
}
