package com.john.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question208 {

	public static void main(String[] args) {

		Trie trie = new Trie();
		System.out.println(trie.search(""));
		trie.insert("johnblahborries");
		System.out.println(trie.search("john"));
		System.out.println(trie.startsWith("john"));
		System.out.println(trie.search("johnblahborries"));
	}

	private static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean isEnd = false;

		public TrieNode() {
		}
	}

	public static class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			TrieNode curr = root;
			for (char c : word.toCharArray()) {
				if (!curr.children.containsKey(c)) {
					curr.children.put(c, new TrieNode());
				}
				curr = curr.children.get(c);
			}

			curr.isEnd = true;
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			TrieNode curr = root;
			for (char c : word.toCharArray()) {
				TrieNode child = curr.children.get(c);
				if (child == null) {
					return false;
				}
				curr = child;
			}

			return curr.isEnd;
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			TrieNode curr = root;
			for (char c : prefix.toCharArray()) {
				TrieNode child = curr.children.get(c);
				if (child == null) {
					return false;
				}
				curr = child;
			}

			return true;
		}
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
}
