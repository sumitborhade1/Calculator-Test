package com.ubs.calculator.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ubs.calculator.service.INumberFilter;

/**
 * @author Sumit Borhade
 *
 * This filter is specifically used for filtering the numbers less than the specified number.
 * 
 * Specified number is not hardcoded, as it requires minimal modifications in the class.
 *
 * So when maxNumber is also changed, no changes are required to handle this scenario.
 */

public class LessThanNumberFilter implements INumberFilter {

	private int maxNumber;
	
	public LessThanNumberFilter(int maxNumber) {
		this.maxNumber = maxNumber;
	}

	public List<Integer> filter(List<Integer> numbers) {
		List<Integer> validNumbers = new ArrayList<Integer>();
		
		for (Integer number : numbers) {
			if(number <= maxNumber) {
				validNumbers.add(number);
			}
		}
		
		return validNumbers;
	}

}