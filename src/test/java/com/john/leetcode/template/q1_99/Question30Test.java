package com.john.leetcode.template.q1_99;

import com.john.utils.ListAssert;
import java.util.List;
import org.junit.Test;

public class Question30Test {
    private Question30 classUnderTest = new Question30();

    @Test
    public void testExample1() {
        String s = "barfoothefoobarman";
        String[] words = new String[] { "foo", "bar" };

        List<Integer> expected = List.of(0, 9);
        ListAssert.assertListEquals(expected, classUnderTest.findSubstring(s, words));

        //        Explanation:
        //    The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
        //    The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
    }

    @Test
    public void testExample2() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[] { "word", "good", "best", "word" };

        List<Integer> expected = List.of();

        //    Explanation:
        //    There is no concatenated substring.
        ListAssert.assertListEquals(expected, classUnderTest.findSubstring(s, words));
    }

    @Test
    public void testExample3() {
        String s = "barfoofoobarthefoobarman";
        String[] words = new String[] { "bar", "foo", "the" };

        List<Integer> expected = List.of(6, 9, 12);
        ListAssert.assertListEquals(expected, classUnderTest.findSubstring(s, words));

        //        Explanation:
        //    The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
        //    The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
        //    The substring
        //    starting at 12is "thefoobar".
        //    It is
        //    the concatenation
        //    of ["the","foo","bar"].
    }
}
