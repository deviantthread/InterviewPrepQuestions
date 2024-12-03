package com.john.leetcode;

public class Question28 {

    public static void main(String[] args) {
        String needle = "john";
        String haystack = "the guy john"; // 14
        System.out.println(new Question28().strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        } else if (needle.equals("")) {
            return 0;
        } else if (haystack.equals("")) {
            return -1;
        }

        int needleHash = needle.hashCode();
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).hashCode() == needleHash) {
                return i;
            }
        }

        return -1;
    }

}
