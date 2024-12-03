package com.john.leetcode;

public class Question168 {

	public static void main(String[] args) {
		int n = 703;
		System.out.println(new Question168().convertToTitle(n));
	}

	public String convertToTitle(int n) {
		String ret = "";

		while (n > 26) {
			int digit = n / 26;
			digit = Math.min(digit, 26);
			boolean isDivisBy26 = n % 26 == 0;
			if (isDivisBy26) {
				digit--;
			}

			ret += String.valueOf((char) (digit + 'A' - 1));
			n -= digit * 26;
		}

		if (n > 0) {
			ret += String.valueOf((char) (n + 'A' - 1));
		}

		return ret;
	}

	public String convertToTitle2(int n) {
		int firstDigit = n / 26;
		boolean isDivisBy26 = n % 26 == 0;
		if (isDivisBy26) {
			firstDigit--;
		}
		String ret = "";
		if (firstDigit > 0) {
			ret = String.valueOf((char) (firstDigit + 'A' - 1));
		}
		int secondDigit = n - (firstDigit * 26);
		ret += String.valueOf((char) (secondDigit + 'A' - 1));

		return ret;
	}
}
