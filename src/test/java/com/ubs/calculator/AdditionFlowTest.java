package com.ubs.calculator;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ubs.calculator.exception.GenericAddException;

public class AdditionFlowTest {

	AdditionFlow additionFlow;
	
	@Before
	public void setUp() {
		additionFlow = new AdditionFlow();
	}
	
	@After
	public void tearDown() {
		additionFlow = null;
	}
	
	@Test
	public void whenEmptyStringIsPassedThenAdditionShouldBeZero() throws GenericAddException {
		long expectedSum = 0;
		String input = "";
		assertTrue(expectedSum == additionFlow.additionOrchestrator(input));
	}
	
	@Test
	public void whenSimpleTwoNumbersArePassedThenAdditionShouldBeCorrect() throws GenericAddException {
		long expectedSum = 3;
		String input = "1,2";
		assertTrue(expectedSum == additionFlow.additionOrchestrator(input));
	}
	
	@Test
	public void whenNewLineIsPassedThenAdditionShouldBeCorrect() throws GenericAddException {
		long expectedSum = 3;
		String input = "1\n2";
		assertTrue(expectedSum == additionFlow.additionOrchestrator(input));
	}
	
	@Test
	public void whenNewLineAndCommaUsedAsDelimitersThenAdditionShouldBeCorrect() throws GenericAddException {
		long expectedSum = 6;
		String input = "1\n2,3";
		assertTrue(expectedSum == additionFlow.additionOrchestrator(input));
	}
	
	@Test(expected=NumberFormatException.class)
	public void whenInvalidInputIsPassedExceptionShouldBeThrown() throws GenericAddException {
		long expectedSum = 6;
		String input = "1,\n";
		assertTrue(expectedSum == additionFlow.additionOrchestrator(input));
	}
	
	@Test
	public void whenSemicolonIsPassedAsDelimiterThenAdditionShouldBeCorrect() throws GenericAddException {
		long expectedSum = 3;
		String input = "//;\n1;2";
		assertTrue(expectedSum == additionFlow.additionOrchestrator(input));
	}

	@Test
	public void whenNegativeNumbersArePassedAsCustomExceptionShouldBeThrown() {
		String input = "//;\n1;2;-3;-1";
		try {
			additionFlow.additionOrchestrator(input);
			fail();
		} catch (GenericAddException e) {
			assertEquals("Negative not allowed : -3 -1", e.getMessage());
		}
	}
	
	@Test
	public void whenNumbersMoreThousandArePassedThenTheseNumbersShouldBeIgnored() throws GenericAddException {
		long expectedSum = 6;
		String input = "1,2,3\n1001,10002";
		assertTrue(expectedSum == additionFlow.additionOrchestrator(input));
	}
	
	@Test
	public void whenDelimitersWithMultipleLengthsArePassedThenTheseAdditionShouldBeCorrect() throws GenericAddException {
		long expectedSum = 6;
		String input = "//***\n1***2***3";
		assertTrue(expectedSum == additionFlow.additionOrchestrator(input));
	}
	
	@Test
	public void whenInputAsNullPassedThenAdditionShouldBeZero() throws GenericAddException {
		long expectedSum = 0;
		String input = null;
		assertTrue(expectedSum == additionFlow.additionOrchestrator(input));
	}
	
	@Test
	public void whenMultipleDelimitersWithSingleLengthsArePassedThenTheseAdditionShouldBeCorrect() throws GenericAddException {
		long expectedSum = 6;
		String input = "//*|,\n1*2,3";
		assertTrue(expectedSum == additionFlow.additionOrchestrator(input));
	}
	
	@Test
	public void whenMultipleDelimitersWithMultipleLengthsArePassedThenTheseAdditionShouldBeCorrect() throws GenericAddException {
		long expectedSum = 8;
		String input = "//**|,,\n1**2,,5";
		assertTrue(expectedSum == additionFlow.additionOrchestrator(input));
	}

}
