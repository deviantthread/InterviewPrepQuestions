package com.john.Nov2022.leetcode.q200_299;

import com.john.Nov2022.leetcode.q200_299.Question208.Trie;
import org.junit.Assert;
import org.junit.Test;

public class Question208Test {
    private final Question208 classUnderTest = new Question208();

    @Test
    public void testExample1() {
        //        Input
        //            ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
        //[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
        //        Output
        //            [null, null, true, false, true, null, true]

        Trie trie = new Trie();
        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));   // return True
        Assert.assertFalse(trie.search("app"));     // return False
        Assert.assertTrue(trie.startsWith("app")); // return True
        trie.insert("app");
        Assert.assertTrue(trie.search("app"));     // return True
    }
}
