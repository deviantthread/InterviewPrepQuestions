package com.john.leetcode;

import org.apache.commons.lang3.time.StopWatch;

public class Question70 {

    public static void main(String[] args) {
        int n = 44;
        StopWatch sw = new StopWatch();
        sw.start();
        System.out.println(new Question70().climbStairs(n));
        sw.stop();
        System.out.println("took ms: " + sw.getTime());
    }

    public int climbStairs(int n) {
        int[] mem = new int[n + 1];
        return climbStairs(n, mem);
    }

    public int climbStairs(int n, int[] mem) {
        if (n < 3) {
            return n;
        }
        if (mem[n] != 0) {
            return mem[n];
        }

        int i = climbStairs(n - 1, mem) + climbStairs(n - 2, mem);
        mem[n] = i;
        return i;
    }
}
