package com.john.Nov2022.leetcode.q1_50;

public class Question5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        char[] ary = s.toCharArray();
        int maxLen = 1;
        int maxStart = 0;
        int maxEnd = 0;

        for (int start = 0; start < ary.length; start++) {

            //odd
            int oddStart = start;
            int oddEnd = start;
            int currLen = 1;
            while (oddStart >= 0 && oddEnd < ary.length) {
                if (ary[oddStart] != ary[oddEnd]) {
                    break;
                }

                if (currLen > maxLen) {
                    maxLen = currLen;
                    maxStart = oddStart;
                    maxEnd = oddEnd;
                }
                currLen += 2;
                oddStart--;
                oddEnd++;
            }

            //even
            int evenStart = start;
            int evenEnd = start + 1;
            currLen = 2;
            while (evenStart >= 0 && evenEnd < ary.length) {
                if (ary[evenStart] != ary[evenEnd]) {
                    break;
                }

                if (currLen > maxLen) {
                    maxLen = currLen;
                    maxStart = evenStart;
                    maxEnd = evenEnd;
                }
                currLen += 2;
                evenStart--;
                evenEnd++;
            }
        }

        return s.substring(maxStart, maxEnd + 1);
    }
}
