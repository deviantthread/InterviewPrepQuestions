package com.john.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question242 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isAnagram(String s, String t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}

		Map<Character, Integer> chars = new HashMap<Character, Integer>();
		for (Character c : s.toCharArray()) {
			if (!chars.containsKey(c)) {
				chars.put(c, 0);
			}

			int count = chars.get(c);
			chars.put(c, count + 1);
		}

		for (Character c : t.toCharArray()) {
			if (!chars.containsKey(c)) {
				return false;
			}

			int count = chars.get(c);
			chars.put(c, count - 1);
		}

		for (int count : chars.values()) {
			if (count != 0) {
				return false;
			}
		}

		return true;
	}
}
