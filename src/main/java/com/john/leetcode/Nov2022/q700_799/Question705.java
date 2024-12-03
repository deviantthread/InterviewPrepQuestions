package com.john.leetcode.Nov2022.q700_799;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Question705 {
    public static class MyHashSet {
        List<Integer>[] buckets = new List[10];

        public MyHashSet() {

        }

        public void add(int key) {
            int hash = hash(key);
            if (buckets[hash] == null) {
                buckets[hash] = new LinkedList<>();
            }

            if (!buckets[hash].contains(key)) {
                buckets[hash].add(key);
            }
        }

        public void remove(int key) {
            int hash = hash(key);

            if (buckets[hash] == null || !buckets[hash].contains(key)) {
                return;
            }

            buckets[hash].remove((Object)key);

            if (buckets[hash].isEmpty()) {
                buckets[hash] = null;
            }
        }

        public boolean contains(int key) {
            int hash = hash(key);

            return buckets[hash] != null && buckets[hash].contains(key);
        }

        private int hash(int val) {
            return Math.abs(Integer.hashCode(val)) % buckets.length;
        }

        // for testing
        public int[] toAry() {
            return Arrays.stream(buckets)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .mapToInt(i -> i)
                .toArray();
        }
    }
}
