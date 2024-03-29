package com.john.Nov2022.leetcode.q1_99;

public class Question58 {
    public int lengthOfLastWord(String s) {
        // start at back,

        // skip over ending whitespace if appropriate
        int idx;
        for (idx = s.length() - 1; idx >= 0; idx--) {
            if (!Character.isWhitespace(s.charAt(idx))) {
                break;
            }
        }

        // start counting backwards until we reach start of string or whitespace
        int count = 0;
        for (; idx >= 0 && !Character.isWhitespace(s.charAt(idx)); idx--) {
            count++;
        }

        return count;
    }
}
