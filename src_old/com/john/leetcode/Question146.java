package com.john.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question146 {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);

		cache.set(1, 100);
		cache.set(2, 101);
		cache.set(3, 102);
		cache.set(4, 103);
		System.out.println(cache.tail.key);
		cache.get(1);
		System.out.println(cache.tail.key);
	}

	public static class LRUCache {
		private Node tail = null;
		private Node head = null;

		private Map<Integer, Node> map;
		private int capacity;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			map = new HashMap<Integer, Node>(capacity);
		}

		public int get(int key) {
			if (!map.containsKey(key)) {
				return -1;
			}

			Node n = map.get(key);
			moveToHead(n);

			return n.val;
		}

		private void moveToHead(Node n) {
			if (tail == null) {
				tail = n;
			} else if (tail == n) {
				moveTailForward();
			}

			if (n.prev != null) {
				n.prev.next = n.next;
			}

			if (n.next != null) {
				n.next.prev = n.prev;
			}

			Node oldHead = head;
			n.prev = oldHead;
			n.next = null;
			if (oldHead != null) {
				oldHead.next = n;
			}

			head = n;
		}

		public void set(int key, int value) {
			// update existing key-value
			if (map.containsKey(key)) {
				Node n = map.get(key);
				n.val = value;
				moveToHead(n);
				return;
			}

			// reached capacity, delete least recently used
			if (map.size() == capacity) {
				Node n = tail;
				moveTailForward();
				map.remove(n.key);
			}

			// add new key-value
			Node n = new Node();
			n.key = key;
			n.val = value;
			moveToHead(n);
			map.put(key, n);
		}

		private void moveTailForward() {
			tail = tail.next;
			if (tail != null) {
				tail.prev = null;
			}
		}
	}

	private static class Node {
		Node next;
		Node prev;
		int key;
		int val;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return String.valueOf(key) + ":" + String.valueOf(val);
		}
	}
}
