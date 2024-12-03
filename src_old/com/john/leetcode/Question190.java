package com.john.leetcode;

public class Question190 {

    public static void main(String[] args) {
        int n = 43261596;
        System.out.print(new Question190().reverseBits(n));
    }

    public int reverseBits(int n) {
        int k = 0;

        for (int i = 0; i < 32; i++) {
            int bit = n & 1;

            k = k << 1;
            k = k | bit;
            n = n >> 1;
        }

        return k;
    }
}
