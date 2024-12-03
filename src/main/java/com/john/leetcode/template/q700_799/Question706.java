package com.john.leetcode.template.q700_799;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Question706 {
    public static class MyHashMap {
        Pair[] buckets = new Pair[10];

        public MyHashMap() {
        }

        public void put(int key, int value) {
            int hash = hash(buckets, key);
            if (buckets[hash] != null && buckets[hash].key != key) {
                resize(3);
                put(key, value);
            }

            buckets[hash] = new Pair(key, value);
        }

        private void resize(int growFactor) {
            Pair[] newBuckets = new Pair[buckets.length * growFactor];
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    int newHash = hash(newBuckets, buckets[i].key);

                    // new collision, doh, try an even bigger array
                    if (newBuckets[newHash] != null) {
                        resize(growFactor + 1);
                        return;
                    }

                    newBuckets[newHash] = buckets[i];
                }
            }
            buckets = newBuckets;
        }

        public int get(int key) {
            int hash = hash(buckets, key);
            if (buckets[hash] == null || buckets[hash].key != key) {
                return -1;
            }

            return buckets[hash].value;
        }

        public void remove(int key) {
            int hash = hash(buckets, key);
            if (buckets[hash] != null && buckets[hash].key == key) {
                buckets[hash] = null;
            }
        }

        private int hash(Pair[] buckets, int val) {
            return Math.abs(Integer.hashCode(val)) % buckets.length;
        }

        private static class Pair {
            int key;
            int value;

            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public Map<Integer, Integer> asMap() {
            return Arrays.stream(buckets)
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(p -> p.key, p -> p.value));
        }
    }
}
