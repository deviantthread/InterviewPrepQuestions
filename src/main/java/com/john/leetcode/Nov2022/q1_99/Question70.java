package com.john.leetcode.Nov2022.q1_99;

public class Question70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        return climbStairs(n, mem);
    }

    private int climbStairs(int n, int[] mem) {
        if (mem[n - 1] != 0) {
            return mem[n - 1];
        }

        int val = climbStairs(n - 2, mem) + climbStairs(n - 1, mem);
        mem[n - 1] = val;
        return val;
    }
}
