package com.ubs.calculator.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ubs.calculator.service.INumberFilter;

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
