package com.john.leetcode.Nov2022.q1_99;

import com.john.utils.CollectionCreator;
import com.john.utils.ListAssert;
import java.util.List;
import org.junit.Test;

public class Question68Test {
    private Question68 classUnderTest = new Question68();

    @Test
    public void testExample1() {
        String[] words = CollectionCreator.createArrayString("[ThisDELisDELanDELexampleDELofDELtextDELjustification.]");
        int maxWidth = 16;
        List<String> expected = CollectionCreator.createListString("[This    is    anDELexample  of textDELjustification.  ]");
        ListAssert.assertListEquals(expected, classUnderTest.fullJustify(words, maxWidth));
    }

    @Test
    public void testExample2() {
        String[] words = CollectionCreator.createArrayString("[WhatDELmustDELbeDELacknowledgmentDELshallDELbe]");
        int maxWidth = 16;
        List<String> expected = CollectionCreator.createListString("[What   must   beDELacknowledgment  DELshall be        ]");
        ListAssert.assertListEquals(expected, classUnderTest.fullJustify(words, maxWidth));

        //        Explanation:
        //        Note that the last line is "shall be    " instead of "shall     be", because the last line must be left
        //        -justified instead of fully - justified.
        //            Note that the second line is also left - justified because it contains only one word.
    }

    @Test
    public void testExample3() {
        String[] words = CollectionCreator.createArrayString("[ScienceDELisDELwhatDELweDELunderstandDELwellDELenoughDELtoDELexplainDELtoDELaDELcomputer.DELArtDELisDELeverythingDELelseDELweDELdo]");
        int maxWidth = 20;
        List<String> expected = CollectionCreator.createListString("[Science  is  what weDELunderstand      wellDELenough to explain toDELa  computer.  Art isDELeverything  else  weDELdo                  ]");
        ListAssert.assertListEquals(expected, classUnderTest.fullJustify(words, maxWidth));
    }

    @Test
    public void testExample4() {
        String[] words = CollectionCreator.createArrayString("[ListenDELtoDELmany,DELspeakDELtoDELaDELfew.]");
        int maxWidth = 6;
        List<String> expected = CollectionCreator.createListString("[ListenDELto    DELmany, DELspeak DELto   aDELfew.  ]");
        ListAssert.assertListEquals(expected, classUnderTest.fullJustify(words, maxWidth));
    }

    @Test
    public void testExample5() {
        String[] words = CollectionCreator.createArrayString("[a]");
        int maxWidth = 1;
        List<String> expected = CollectionCreator.createListString("[a]");
        ListAssert.assertListEquals(expected, classUnderTest.fullJustify(words, maxWidth));
    }
}
