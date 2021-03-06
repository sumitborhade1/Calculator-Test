package com.ubs.calculator.service.impl;

import java.util.List;

import com.ubs.calculator.exception.GenericAddException;
import com.ubs.calculator.service.IValidationRule;

/**
 * @author Sumit Borhade
 * 
 * This class performs the validations using the list of specified validation rules.
 * 
 */
public class PerformValidations {

	private List<IValidationRule> validationRules;

	public PerformValidations(List<IValidationRule> validationRules) {
		super();
		this.validationRules = validationRules;
	}

	public void validateInput(List<Integer> numbers) throws GenericAddException {
		for (IValidationRule validationRule : validationRules) {
			validationRule.isInputValid(numbers);
		}
	}
}