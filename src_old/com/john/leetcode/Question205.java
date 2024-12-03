package com.john.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question205 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		Map<Character, Character> map2 = new HashMap<Character, Character>();

		for (int i = 0; i < s.length(); i++) {
			// a -> b
			if (map.containsKey(s.charAt(i))) {
				if (map.get(s.charAt(i)) != t.charAt(i)) {
					return false;
				}
				// nothing else can go to b either
			} else if (map2.containsKey(t.charAt(i))) {
				if (map2.get(t.charAt(i)) != s.charAt(i)) {
					return false;
				}
			} else {
				map.put(s.charAt(i), t.charAt(i));
				map2.put(t.charAt(i), s.charAt(i));
			}
		}

		return true;
	}

}
