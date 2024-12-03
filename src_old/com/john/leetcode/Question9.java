package com.john.leetcode;

public class Question9 {

    public static void main(String[] args) {
        int x = 12;

        boolean b = new Question9().isPalindrome(x);
        System.out.print(b);

    }

    public boolean isPalindrome(int x) {
        char[] ary = String.valueOf(x).toCharArray();
        int start = 0;
        int end = ary.length - 1;
        while (start < end) {
            if (ary[start++] != ary[end--]) {
                return false;
            }
        }
        return true;
    }
}
