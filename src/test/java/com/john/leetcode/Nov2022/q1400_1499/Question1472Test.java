package com.john.leetcode.Nov2022.q1400_1499;

import com.google.common.collect.Lists;
import com.john.leetcode.Nov2022.q1400_1499.Question1472.BrowserHistory;
import com.john.utils.ListAssert;
import org.junit.Test;

public class Question1472Test {
    private final Question1472 classUnderTest = new Question1472();

    @Test
    public void testExample1() {

        //    Input:
        //        ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
        //        [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
        //    Output:
        //        [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

        //        Explanation:
        String lc = "leetcode.com";
        String gg = "google.com";
        String fb = "facebook.com";
        String yt = "youtube.com";
        String li = "linkedin.com";
        BrowserHistory browserHistory = new BrowserHistory(lc);
        ListAssert.assertListEquals(Lists.newArrayList(lc), browserHistory.backToArray());
        browserHistory.visit(gg);       // You are in "leetcode.com". Visit "google.com"
        ListAssert.assertListEquals(Lists.newArrayList(lc, gg), browserHistory.backToArray());
        browserHistory.visit(fb);     // You are in "google.com". Visit "facebook.com"
        ListAssert.assertListEquals(Lists.newArrayList(lc, gg, fb), browserHistory.backToArray());
        browserHistory.visit(yt);      // You are in "facebook.com". Visit "youtube.com"
        browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        ListAssert.assertListEquals(Lists.newArrayList(lc, gg, fb), browserHistory.backToArray());
        browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
        ListAssert.assertListEquals(Lists.newArrayList(lc, gg), browserHistory.backToArray());
        browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        ListAssert.assertListEquals(Lists.newArrayList(lc, gg, fb), browserHistory.backToArray());
        browserHistory.visit(li);     // You are in "facebook.com". Visit "linkedin.com"
        ListAssert.assertListEquals(Lists.newArrayList(lc, gg, fb, li), browserHistory.backToArray());
        browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
        ListAssert.assertListEquals(Lists.newArrayList(lc, gg, fb, li), browserHistory.backToArray());
        browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        ListAssert.assertListEquals(Lists.newArrayList(lc, gg), browserHistory.backToArray());
        browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"}
        ListAssert.assertListEquals(Lists.newArrayList(lc), browserHistory.backToArray());
    }
}