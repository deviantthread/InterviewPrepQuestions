package com.john.Nov2022.leetcode.q1_50;

public class Question28 {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (strStr(haystack, needle, i)) {
                return i;
            }
        }

        return -1;
    }

    private boolean strStr(String haystack, String needle, int haystackPosition) {
        for (int needleIdx = 0; needleIdx < needle.length(); needleIdx++) {
            int haystackIdx = haystackPosition + needleIdx;
            if (haystackIdx >= haystack.length()) {
                return false;
            } else if (haystack.charAt(haystackIdx) != needle.charAt(needleIdx)) {
                return false;
            }
        }

        return true;
    }
}
