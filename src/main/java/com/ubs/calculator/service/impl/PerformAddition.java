package com.ubs.calculator.service.impl;

import java.util.List;

/**
 * @author Sumit Borhade
 * 
 * This class performs the addition of given numbers.
 * 
 * Result is returned using long as input could be multiple and may have higher values of Integers.
 * 
 */
public class PerformAddition {

	public long addition(List<Integer> numbers) {
		long sum = 0;
		for (Integer integer : numbers) {
			sum += integer.longValue();
		}
		return sum;
	}
}
