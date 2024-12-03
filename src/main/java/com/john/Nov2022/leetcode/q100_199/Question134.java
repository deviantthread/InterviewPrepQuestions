package com.john.Nov2022.leetcode.q100_199;

public class Question134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (canComplete(gas, cost, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean canComplete(int[] gas, int[] cost, int startingIdx) {
        int tank = gas[startingIdx];
        int i = startingIdx;
        boolean firstPass = true;
        while (i != startingIdx || firstPass) {
            firstPass = false;
            //can't make it with the gas i have
            if (tank < cost[i]) {
                return false;
            }

            // drive to next station
            tank -= cost[i];

            i++;
            if (i == gas.length) {
                i = 0;
            }

            // fill up at next station
            tank += gas[i];
        }

        return true;
    }
}
