package com.ubs.calculator.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ubs.calculator.model.InputModel;

public class ExtractNumbersTest {

	ExtractNumbers extractNumbers;
	
	@Before
	public void setUp() throws Exception {
		extractNumbers = EasyMock.createMock(ExtractNumbers.class);
	}

	@After
	public void tearDown() throws Exception {
		extractNumbers = null;
	}

	@Test
	public void testExtractNumbers() {
		List<Integer> expectedList = new ArrayList<Integer>();
		expectedList.add(1);
		expectedList.add(2);		
		EasyMock.expect(extractNumbers.extractNumbers(EasyMock.isA(InputModel.class)) ).andReturn(expectedList);
		Assert.assertTrue(expectedList.contains(1));
		
	}

}
