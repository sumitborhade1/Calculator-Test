package com.ubs.calculator.service.impl;

import java.util.List;

public class PerformAddition {

	public long addition(List<Integer> numbers) {
		long sum = 0;
		for (Integer integer : numbers) {
			sum += integer.longValue();
		}
		return sum;
	}
}
