package com.john.leetcode.Nov2022.q100_199;

import com.john.leetcode.Nov2022.q100_199.Question146.LRUCache;
import org.junit.Assert;
import org.junit.Test;

public class Question146Test {
    private Question146 classUnderTest = new Question146();

    @Test
    public void testExample1() {
        //    Input
        //["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
        //    [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
        //    Output
        //[null, null, null, 1, null, -1, null, -1, 3, 4]

        //    Explanation
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        Assert.assertEquals(1, lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        Assert.assertEquals(-1, lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        Assert.assertEquals(-1, lRUCache.get(1));    // return -1 (not found)
        Assert.assertEquals(3, lRUCache.get(3));    // return 3
        Assert.assertEquals(4, lRUCache.get(4));    // return 4}
    }
}
