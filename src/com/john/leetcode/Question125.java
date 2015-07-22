package com.john.leetcode;

public class Question125 {

    public static void main(String[] args) {
        String s = "1a2";
        System.out.println(new Question125().isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        int start = -1;
        int end = s.length();
        start = inc(s, start);
        end = dec(s, end);

        while (start < end) {
            if (!s.substring(start, start + 1).equalsIgnoreCase(s.substring(end, end + 1))) {
                return false;
            }

            start = inc(s, start);
            end = dec(s, end);
        }

        return true;
    }

    private int inc(String s, int start) {
        while (++start < s.length()) {
            if (isAlpha(s, start)) {
                break;
            }
        }

        return start;
    }

    private int dec(String s, int end) {
        while (--end >= 0) {
            if (isAlpha(s, end)) {
                break;
            }
        }

        return end;
    }

    private boolean isAlpha(String s, int idx) {
        return Character.isLetter(s.charAt(idx)) || Character.isDigit(s.charAt(idx));
    }

}
