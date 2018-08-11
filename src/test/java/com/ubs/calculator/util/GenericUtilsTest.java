package com.ubs.calculator.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GenericUtilsTest {

	@Test
	public void test() {
		String expectedResult = "\\*\\*\\*";
		String input = "***";
		assertEquals(expectedResult, (GenericUtils.escapeMetaCharacters(input)));
	}

}
