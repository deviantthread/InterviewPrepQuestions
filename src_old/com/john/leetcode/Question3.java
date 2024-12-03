package com.john.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question3 {
    public static void main(String[] args) {
        String s = "abba";

        int lengthOfLongestSubstring = new Question3().lengthOfLongestSubstring(s);
        System.out.println(lengthOfLongestSubstring);
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> char2Index = new HashMap<Character, Integer>();
        char[] ary = s.toCharArray();
        int start = 0;
        for (int end = 0; end < ary.length; end++) {
            if (char2Index.containsKey(ary[end])) {
                start = Math.max(start, char2Index.get(ary[end]) + 1);
            }
            char2Index.put(ary[end], end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

}
