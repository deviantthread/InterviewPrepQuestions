package com.john.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question12 {

	public static void main(String[] args) {
		int num = 450;
		System.out.println(new Question12().intToRoman(num));
	}

	public String intToRoman(int num) {
		List<Rom> list = new ArrayList<Rom>() {
			{
				add(new Rom(1000, "m"));
				add(new Rom(900, "cm"));
				add(new Rom(500, "d"));
				add(new Rom(400, "cd"));
				add(new Rom(100, "c"));
				add(new Rom(90, "xc"));
				add(new Rom(50, "l"));
				add(new Rom(40, "xl"));
				add(new Rom(10, "x"));
				add(new Rom(9, "ix"));
				add(new Rom(5, "v"));
				add(new Rom(4, "iv"));
				add(new Rom(1, "i"));
			}
		};
		String s = "";
		while (num > 0) {
			Rom r = findHighest(num, list);
			s += r.rom;
			num -= r.val;
		}

		return s.toUpperCase();
	}

	private Rom findHighest(int num, List<Rom> list) {
		for (Rom rom : list) {
			if (rom.val <= num) {
				return rom;
			}
		}
		return null;
	}

	private static class Rom {
		String rom;
		int val;

		public Rom(int val, String rom) {
			this.rom = rom;
			this.val = val;
		}
	}

}
