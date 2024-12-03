package com.john.Nov2022.leetcode.q100_199;

public class Question191 {
    public int hammingWeight(int n) {
        int count = 0;

        while (n > 0) {
            count += n % 2;
            n = n >> 1;
        }
        return count;
    }
}
