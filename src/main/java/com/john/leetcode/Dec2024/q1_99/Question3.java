package com.john.leetcode.Dec2024.q1_99;

import java.util.HashSet;
import java.util.Set;

public class Question3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> windowChars = new HashSet<>();
        char[] ary = s.toCharArray();
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while(right < ary.length && left < ary.length) {
            // expand
            if(!windowChars.contains(ary[right])) {
                windowChars.add(ary[right]);
                right++;
                maxLen = Math.max(maxLen, windowChars.size());
            } else {
                // shrink
                windowChars.remove(ary[left]);
                left++;
            }
        }

        return maxLen;
    }
}