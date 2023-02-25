package com.john.Nov2022.leetcode.q500_599;

public class Question509 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int mem[] = new int[n + 1];

        return fib(n, mem);
    }

    private int fib(int n, int[] mem) {
        if (mem[n] != 0) {
            return mem[n];
        } else if (n < 2) {
            mem[n] = n;
            return n;
        }

        mem[n] = fib(n - 1, mem) + fib(n - 2);
        return mem[n];
    }
}
