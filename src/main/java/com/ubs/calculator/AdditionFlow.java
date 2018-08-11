package com.ubs.calculator;

import java.util.ArrayList;
import java.util.List;

import com.ubs.calculator.exception.GenericAddException;
import com.ubs.calculator.model.InputModel;
import com.ubs.calculator.service.IExtractNumbers;
import com.ubs.calculator.service.INumberFilter;
import com.ubs.calculator.service.IValidationRule;
import com.ubs.calculator.service.impl.ExtractNumbers;
import com.ubs.calculator.service.impl.FilterUnwantedData;
import com.ubs.calculator.service.impl.FindDelimiterAndOperationalInput;
import com.ubs.calculator.service.impl.LessThanNumberFilter;
import com.ubs.calculator.service.impl.NegativeNumberValidation;
import com.ubs.calculator.service.impl.PerformAddition;
import com.ubs.calculator.service.impl.PerformValidations;

/**
 * This is the starting point for Addition
 * @author Sumit Borhade
 *
 */
public class AdditionFlow {

	public static String DEFAULT_DELIMITER = ",|\n";
	public static int MAX_NUMBER_LIMIT = 1000;
	
	private FindDelimiterAndOperationalInput findDelimiterAndOperationalInput;
	private IExtractNumbers extractNumbers;
	private PerformValidations performValidations;
	private FilterUnwantedData filterUnwantedData;
	private PerformAddition performAddition;
	
	public AdditionFlow() {
		findDelimiterAndOperationalInput();
		extractNumbers();
		validationRules();
		filters();
		addition();
	}
	
	//1. Find delimiter and operational input
	//2. Extract numbers
	//3. Validate input
	//4. Filter
	//5. Show result

	public long additionOrchestrator(String input) throws GenericAddException {
		AdditionFlow add = new AdditionFlow();
		InputModel inputModel = add.findDelimiterAndOperationalInput.delimiterOrchestrator(input);
		List<Integer> numbers = add.extractNumbers.extractNumbers(inputModel);
		add.performValidations.validateInput(numbers);
		numbers = add.filterUnwantedData.filterData(numbers);
		long sum = add.performAddition.addition(numbers);
		return sum;
	}
	
	private void findDelimiterAndOperationalInput() {
		findDelimiterAndOperationalInput = new FindDelimiterAndOperationalInput(DEFAULT_DELIMITER);
	}
	
	private void extractNumbers() {
		extractNumbers = new ExtractNumbers();
	}
	
	private void validationRules() {
		List<IValidationRule> validationRules = new ArrayList<IValidationRule>();
		IValidationRule validateNegativeNumbers = new NegativeNumberValidation();
		validationRules.add(validateNegativeNumbers);
		performValidations = new PerformValidations(validationRules);
	}

	private void filters() {
		List<INumberFilter> filters = new ArrayList<INumberFilter>();
		INumberFilter lessThanNumberFilter = new LessThanNumberFilter(MAX_NUMBER_LIMIT);
		filters.add(lessThanNumberFilter);
		filterUnwantedData = new FilterUnwantedData(filters);
	}
	
	private void addition() {
		performAddition = new PerformAddition();
	}
}