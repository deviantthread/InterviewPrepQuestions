package com.john.leetcode.Dec2024.q1100_1199;

public class Question1137 {
    // T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }

        int[] mem = new int[n + 1];
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 1;
        return tribonacciRecurse(n, mem);
    }

    private int tribonacciRecurse(int n, int[] mem) {
        if (n == 0) {
            return 0;
        } else if (mem[n] != 0) {
            return mem[n];
        }

        int result = tribonacciRecurse(n - 1, mem) +
            tribonacciRecurse(n - 2, mem) +
            tribonacciRecurse(n - 3, mem);

        mem[n] = result;
        return result;
    }
}
