package com.john.Nov2022.leetcode.q1_50;

import java.util.HashSet;
import java.util.Set;

public class Question3 {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        Set<Character> charsInWindow = new HashSet<>();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char letter = s.charAt(right);
            if (charsInWindow.contains(letter)) {
                while (left < right && charsInWindow.contains(letter)) {
                    charsInWindow.remove(s.charAt(left++));
                }
            }
            charsInWindow.add(letter);
            longest = Math.max(longest, charsInWindow.size());
        }

        return longest;
    }
}
