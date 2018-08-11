package com.ubs.calculator.service.impl;

import java.util.List;

import com.ubs.calculator.service.INumberFilter;

public class FilterUnwantedData {

	private List<INumberFilter> filters;

	public FilterUnwantedData(List<INumberFilter> filters) {
		super();
		this.filters = filters;
	}

	public List<Integer> filterData(List<Integer> numbers) {
		for (INumberFilter filter : filters) {
			numbers = filter.filter(numbers);
		}
		return numbers;
	}
}
