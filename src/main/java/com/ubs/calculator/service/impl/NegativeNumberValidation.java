package com.ubs.calculator.service.impl;

import java.util.List;

import com.ubs.calculator.constants.CalculatorConstants;
import com.ubs.calculator.exception.GenericAddException;
import com.ubs.calculator.exception.NegativeNumbersPresentException;
import com.ubs.calculator.service.IValidationRule;

public class NegativeNumberValidation implements IValidationRule {

	public void isInputValid(List<Integer> numbers) throws GenericAddException {
		StringBuilder negativeNumbers = new StringBuilder(CalculatorConstants.NEGATIVE_NUMBERS_INIT_EXCEPTION_MESSAGE);
		boolean isValid = true;

		for (Integer number : numbers) {
			if(number < 0) {
				negativeNumbers = negativeNumbers.append(CalculatorConstants.SPACE + number);
				isValid = false;
			}
		}
			
		if(!isValid) {
			throw new NegativeNumbersPresentException(negativeNumbers.toString());
		}
	}

}