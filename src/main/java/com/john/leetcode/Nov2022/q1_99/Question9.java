package com.john.leetcode.Nov2022.q1_99;

public class Question9 {
    public boolean isPalindrome(int x) {
        // negatives can't be palindromes
        if (x < 0) {
            return false;
        }

        // get length of int
        // pointers at 10^0 and 10^len
        // number mod by pointers. compare if they're equal
        // move points in
        // stop when comparison is false or pointers

        int len = findLength(x);
        int[] digits = new int[len];

        //backwards
        for (int idx = digits.length - 1; idx >= 0; idx--) {
            digits[idx] = x % 10;
            x = x / 10;
        }

        int left = 0;
        int right = digits.length - 1;
        while (left < right) {
            if (digits[left++] != digits[right--]) {
                return false;
            }
        }

        return true;
    }

    private int findLength(int x) {
        int len = 1;

        while (x > 0) {
            x = x / 10;
            len++;
        }

        return len - 1;
    }
}
