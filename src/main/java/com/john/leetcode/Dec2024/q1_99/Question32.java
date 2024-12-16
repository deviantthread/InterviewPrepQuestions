package com.john.leetcode.Dec2024.q1_99;

import java.util.Arrays;

public class Question32 {
    public int longestValidParentheses(String s) {
        int longest = 0;
        int[] maxLenAtIdx = new int[s.length()];
        Arrays.fill(maxLenAtIdx, -1);

        for (int i = 0; i < s.length(); i++) {
            longest = Math.max(longest, findLongestAt(s, i, 0, 0, 0, maxLenAtIdx));
        }

        return longest;
    }

    private int findLongestAt(String s, int idx, int lenCount, int openCount, int closeCount, int[] maxLenAtIdx) {
        // we closed too many times, remove one of em and exit
        if (closeCount > openCount) {
            return lenCount - 2;
            // we ran out of s, we got as far as we can
        } else if (idx >= s.length()) {
            return lenCount;
        }

        int longestAt;
        //we've already been here, eclipse that amount and jump ahead to see if we can grab more
        if (maxLenAtIdx[idx] > 0) {
            longestAt = findLongestAt(s, idx + maxLenAtIdx[idx], lenCount + maxLenAtIdx[idx], openCount, closeCount, maxLenAtIdx);
            //open, grab it and move forward
        } else if (s.charAt(idx) == '(') {
            longestAt = findLongestAt(s, idx + 1, lenCount, openCount + 1, closeCount, maxLenAtIdx);
            // close, jump up the len count and move forward (we'll check if we had a open paren next
        } else {
            longestAt = findLongestAt(s, idx + 1, lenCount + 2, openCount, closeCount + 1, maxLenAtIdx);
        }
        maxLenAtIdx[idx] = longestAt;
        return longestAt;
    }
}
