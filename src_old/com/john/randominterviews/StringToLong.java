package com.john.randominterviews;

/// source code file

import java.util.regex.Pattern;

public class StringToLong {

	private static final Pattern VALID_INPUT_PATTERN = Pattern.compile("[\\-\\+]?[0-9]+");

	/**
	 * Custom implementation of Long#parseLong() see {@link Long#parseLong()}
	 * 
	 * @param num
	 *            The string representation of a long value
	 * @throws NumberFormatException
	 *             for invalid input
	 * @return The long representation of the input string
	 */
	public static long parseLong(String num) {
		validateInput(num);
		num = stripPlusSignIfNeeded(num);

		boolean isPos = num.charAt(0) != '-';
		if (!isPos) {
			num = num.substring(1, num.length());
		}

		long currNum = 0L;
		int exp = 0;
		for (int i = num.length() - 1; i >= 0; i--) {
			long digit = num.charAt(i) - '0';
			digit *= Math.pow(10, exp);

			verifyNoOverflow(currNum, digit, isPos);

			if (isPos) {
				currNum += digit;
			} else {
				currNum -= digit;
			}
			exp++;
		}

		return currNum;
	}

	private static void verifyNoOverflow(long currNum, long digit, boolean isPos) {
		if (isPos) {
			if (Long.MAX_VALUE - currNum < digit) {
				throw new NumberFormatException("overflow Long max value");
			}
		} else {
			if (Long.MIN_VALUE - currNum > -digit) {
				throw new NumberFormatException("overflow Long min value");
			}
		}
	}

	private static String stripPlusSignIfNeeded(String num) {
		if (num.charAt(0) == '+') {
			return num.substring(1);
		}

		return num;
	}

	// valid: -123, +123, and 123
	// invalid: 12k3, " 123 ", "12.0", "45L"
	private static void validateInput(String num) {
		if (num == null) {
			throw new NumberFormatException("No input");
		}

		if (!VALID_INPUT_PATTERN.matcher(num).matches()) {
			throw new NumberFormatException("Invalid input: " + num);
		}
	}
}
