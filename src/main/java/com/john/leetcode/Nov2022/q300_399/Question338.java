package com.john.leetcode.Nov2022.q300_399;

public class Question338 {
    public int[] countBits(int n) {
        if (n <= 0) {
            return new int[0];
        }

        int[] ret = new int[n + 1];

        for (int i = 1; i < ret.length; i++) {
            int prevVal = ret[i - 1];
            int currBit = i & 1;
            ret[i] = prevVal + currBit;
        }

        return ret;
    }
}
