package com.john.leetcode;

public class Question191 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Question191().hammingWeight(n));
    }

    public int hammingWeight(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n = n >> 1;
        }

        return count;
    }
}
