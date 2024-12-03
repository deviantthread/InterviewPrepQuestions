package com.john.leetcode.Nov2022.q1000_1099;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            queue.offer(stone);
        }

        while (queue.size() > 1) {
            int heaviestStone = queue.poll();
            int secondHeaviestStone = queue.poll();

            int newStone = heaviestStone - secondHeaviestStone;
            if (newStone > 0) {
                queue.offer(newStone);
            }
        }

        if (queue.size() == 1) {
            return queue.poll();
        }

        return 0;
    }
}
