package com.john.leetcode.Dec2024.q1500_1599;

public class Question1598 {
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if(log.equals("../")){
                depth = depth > 0 ? depth - 1 : 0;
            } else if (log.equals("./")){
                // do nothing
            } else {
                depth++;
            }
        }

        return depth;
    }
}
