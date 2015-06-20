package com.john.leetcode;

public class Question58 {

    public static void main(String[] args) {
        String s = "hi   ";
        System.out.println(new Question58().lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int skipped = 0;
        int i = s.length() - 1;
        while (s.charAt(i) == ' ') {
            i--;
            skipped++;
        }

        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return s.length() - i - 1 - skipped;
            }
        }
        return s.length() - skipped;
    }
}
