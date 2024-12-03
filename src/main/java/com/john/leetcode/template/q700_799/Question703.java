package com.john.leetcode.template.q700_799;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question703 {
    public static class KthLargest {
        private final int k;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());

        public KthLargest(int k, int[] nums) {
            this.k = k;

            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.poll();
            }

            return minHeap.peek();
        }
    }
}
