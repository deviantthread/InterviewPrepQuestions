package com.john.Nov2022.leetcode.q100_199;

import java.util.HashMap;
import java.util.Map;

public class Question146 {
    public static class LRUCache {

        private final int capacity;

        private final Map<Integer, Item> map = new HashMap<>();
        private final Item preHead;
        private final Item postTail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            preHead = new Item(-1, -1);
            postTail = new Item(-1, -1);
            preHead.next = postTail;
            postTail.prev = preHead;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            Item item = map.get(key);

            moveToHead(item);

            return item.value;
        }

        public void put(int key, int value) {
            // updating existing key
            if (map.containsKey(key)) {
                Item item = map.get(key);
                item.value = value;
                moveToHead(item);
            } else {
                // new key
                Item item = new Item(key, value);

                map.put(key, item);

                moveToHead(item);

                if (map.size() > capacity) {
                    trimTail();
                }
            }
        }

        private void trimTail() {
            Item currTail = postTail.prev;

            map.remove(currTail.key);

            Item newTail = currTail.prev;
            if (newTail != preHead) {
                newTail.next = postTail;
                postTail.prev = newTail;
            }
        }

        private void moveToHead(Item newHead) {
            if (newHead.next != null && newHead.prev != null) {
                // its an existing item, need to pluck it out from the middle
                Item prev = newHead.prev;
                Item next = newHead.next;

                prev.next = next;
                next.prev = prev;
            }

            Item currHead = preHead.next;

            currHead.prev = newHead;
            preHead.next = newHead;

            newHead.prev = preHead;
            newHead.next = currHead;
        }
    }

    private static class Item {
        Integer key;
        Integer value;
        Item next;
        Item prev;

        public Item(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
}
