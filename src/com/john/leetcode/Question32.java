package com.john.leetcode;

public class Question32 {

    public static void main(String[] args) {
        String s = "(())";
        System.out.print(new Question32().longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        int[] parens = new int[s.length()];
        for (int i = 0; i < parens.length; i++) {
            parens[i] = -1;
        }

        char[] chars = s.toCharArray();
        int parenLevel = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                parens[i] = ++parenLevel;
            } else {
                if (closeParen(parens, parenLevel, i)) {
                    parenLevel--;
                }
            }
        }

        int currCount = 0;
        int maxCount = 0;
        for (int i = 0; i < parens.length; i++) {
            if (parens[i] == 0) {
                currCount++;
            } else {
                maxCount = Math.max(maxCount, currCount);
                currCount = 0;
            }
        }

        return Math.max(currCount, maxCount);
    }

    private boolean closeParen(int[] parens, int parenLevel, int idx) {
        if (parenLevel < 1) {
            return false;
        }

        for (int i = idx - 1; i >= 0; i--) {
            if (parens[i] == parenLevel) {
                parens[i] = 0;
                parens[idx] = 0;
                return true;
            }
        }
        return false;
    }
}
