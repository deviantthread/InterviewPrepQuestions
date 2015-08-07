package com.john.randominterviews;

// unit test file

import org.junit.Assert;
import org.junit.Test;

// To run the unit tests add junit and hamcrest jars to your build path
// http://search.maven.org/remotecontent?filepath=junit/junit/4.12/junit-4.12.jar
// https://hamcrest.googlecode.com/files/hamcrest-all-1.3.jar
public class StringToLongTest {

	@Test
	public void testOnlyNumbersIsValid() {
		String num = "123";
		long parsed = StringToLong.parseLong(num);

		Assert.assertEquals(123L, parsed);
	}

	@Test
	public void testNumbersWithPlusIsValid() {
		String num = "+123";
		long parsed = StringToLong.parseLong(num);

		Assert.assertEquals(123L, parsed);
	}

	@Test
	public void testOnlyNumbersWithMinusIsValid() {
		String num = "-123";
		long parsed = StringToLong.parseLong(num);

		Assert.assertEquals(-123L, parsed);
	}

	@Test
	public void testMaxLongIsValid() {
		String num = String.valueOf(Long.MAX_VALUE);
		long parsed = StringToLong.parseLong(num);

		Assert.assertEquals(Long.MAX_VALUE, parsed);
	}

	@Test
	public void testMinLongIsValid() {
		String num = String.valueOf(Long.MIN_VALUE);
		long parsed = StringToLong.parseLong(num);

		Assert.assertEquals(Long.MIN_VALUE, parsed);
	}

	@Test(expected = NumberFormatException.class)
	public void testNumbersWithLettersIsNotValid() {
		StringToLong.parseLong("12k3");
	}

	@Test(expected = NumberFormatException.class)
	public void testNumbersWithSpacesIsNotValid() {
		StringToLong.parseLong(" 123 ");
	}

	@Test(expected = NumberFormatException.class)
	public void testNumbersWithDecimalPointIsNotValid() {
		StringToLong.parseLong("12.0");
	}

	@Test(expected = NumberFormatException.class)
	public void testGreaterThanMaxLongWillOverflow() {
		String tooBig = String.valueOf(Long.MAX_VALUE) + "0";

		StringToLong.parseLong(tooBig);
	}

	@Test(expected = NumberFormatException.class)
	public void testLowerThanMinLongWillOverflow() {
		String tooSmall = String.valueOf(Long.MIN_VALUE) + "0";

		StringToLong.parseLong(tooSmall);
	}

	@Test(expected = NumberFormatException.class)
	public void testEmptyStringIsNotValid() {
		StringToLong.parseLong("");
	}

	@Test(expected = NumberFormatException.class)
	public void testNullInputIsNotValid() {
		StringToLong.parseLong(null);
	}

}
