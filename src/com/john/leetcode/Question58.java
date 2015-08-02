package com.john.leetcode;

public class Question58 {

	public static void main(String[] args) {
		String s = "hi";
		System.out.println(new Question58().lengthOfLastWord(s));
	}

	public int lengthOfLastWord(String s) {
		if (s == null || s.equals("")) {
			return 0;
		} else if (isOnlySpaces(s)) {
			return 0;
		}

		String[] regex = s.split(" ");

		String lastWord = regex[regex.length - 1];
		return lastWord.length();
	}

	private boolean isOnlySpaces(String s) {
		for (char c : s.toCharArray()) {
			if (c != ' ') {
				return false;
			}
		}
		return true;
	}
}
