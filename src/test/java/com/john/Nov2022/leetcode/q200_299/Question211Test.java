package com.john.Nov2022.leetcode.q200_299;

import com.john.Nov2022.leetcode.q200_299.Question211.WordDictionary;
import org.junit.Assert;
import org.junit.Test;

public class Question211Test {
    private final Question211 classUnderTest = new Question211();

    @Test
    public void testExample1() {

        //    Input
        //["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
        //    [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
        //    Output
        //[null,null,null,null,false,true,true,true]

        //    Explanation
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        Assert.assertFalse(wordDictionary.search("pad")); // return False
        Assert.assertTrue(wordDictionary.search("bad")); // return True
        Assert.assertTrue(wordDictionary.search(".ad")); // return True
        Assert.assertTrue(wordDictionary.search("b..")); // return True
    }
}
