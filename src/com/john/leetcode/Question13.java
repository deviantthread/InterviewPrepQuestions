package com.john.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question13 {

	public static void main(String[] args) {
		String s = "xix";
		System.out.println(new Question13().romanToInt(s));
	}

	public int romanToInt(String s) {
		s = s.toLowerCase();
		Map<Character, Integer> map = new HashMap<Character, Integer>() {
			{
				put('m', 1000);
				put('d', 500);
				put('c', 100);
				put('l', 50);
				put('x', 10);
				put('v', 5);
				put('i', 1);
			}
		};
		char[] chars = s.toCharArray();
		int num = 0;
		for (int i = 0; i < chars.length; i++) {
			int val = map.get(chars[i]);
			int nextVal = -1;
			if (i + 1 < chars.length) {
				nextVal = map.get(chars[i + 1]);
			}

			if (nextVal > val) {
				num -= val;
			} else {
				num += val;
			}

		}

		return num;
	}

}
