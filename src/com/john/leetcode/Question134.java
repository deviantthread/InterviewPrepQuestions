package com.john.leetcode;

public class Question134 {

    public static void main(String[] args) {
        int[] gas = { 1, 2, 3, 3 };
        int[] cost = { 2, 1, 5, 1 };// should be 3, not 2, getting stuck on 2
        System.out.println(new Question134().canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) {
            return -1;
        } else if (gas.length == 1) {
            if (gas[0] >= cost[0]) {
                return 0;
            } else {
                return -1;
            }
        }

        int start = 0;
        // find a valid start, or -1 if none exist
        while (gas[start] < cost[start]) {
            start++;
            if (start == gas.length) {
                return -1;
            }
        }

        int currGas = gas[start] - cost[start];
        int end = increment(gas, start);
        while (end != start) {
            // tried every start
            if (start == gas.length) {
                return -1;
            }

            int j = currGas + gas[end] - cost[end];
            if (j >= 0) {
                currGas = j;
                end = increment(gas, end);
            } else {
                currGas -= gas[start];
                currGas += cost[start];
                start++;
                // start has caught up to end, but we're not at a stopping condition. try to find a new start
                if (start == end) {
                    while (gas[start] < cost[start]) {
                        start++;
                        if (start == gas.length) {
                            return -1;
                        }
                    }

                    currGas = gas[start] - cost[start];
                    end = increment(gas, start);
                }
            }
        }

        return currGas >= 0 ? start : -1;
    }

    private int increment(int[] gas, int x) {
        x++;
        if (x == gas.length) {
            x = 0;
        }
        return x;
    }

}
