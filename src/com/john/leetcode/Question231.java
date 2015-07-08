package com.john.leetcode;

public class Question231 {

    public static void main(String[] args) {
        int n = Integer.MIN_VALUE;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(new Question231().isPowerOfTwo(n));
    }

    public boolean isPowerOfTwo(int n) {
        boolean hasOne = false;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                if (hasOne) {
                    return false;
                }
                hasOne = true;
            }
            n = n >> 1;
        }

        return hasOne;
    }
}
