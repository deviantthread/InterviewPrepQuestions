package com.john.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question139 {

	public static void main(String[] args) {
		String s = "aaaaaaa";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("aa");
		wordDict.add("aaaa");
		System.out.println(new Question139().wordBreak(s, wordDict));

	}

	public boolean wordBreak(String s, Set<String> wordDict) {
		TrieNode head = createTrie(wordDict);

		TrieNode node = head;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (node.children.containsKey(chars[i])) {
				node = node.children.get(chars[i]);
				if (node.isEnd) {
					node = head;
				}
			} else {
				return false;
			}
		}

		return true;
	}

	private TrieNode createTrie(Set<String> wordDict) {
		TrieNode head = new TrieNode();

		for (String word : wordDict) {
			addWordToTrie(head, word);
		}

		return head;
	}

	private void addWordToTrie(TrieNode head, String word) {
		for (char c : word.toCharArray()) {
			if (!head.children.containsKey(c)) {
				head.children.put(c, new TrieNode());
			}
			head = head.children.get(c);
		}

		head.isEnd = true;
	}

	private static class TrieNode {
		public Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		public boolean isEnd;
	}
}
