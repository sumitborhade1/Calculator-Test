package com.ubs.calculator.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ubs.calculator.constants.CalculatorConstants;
import com.ubs.calculator.model.InputModel;
import com.ubs.calculator.util.GenericUtils;

/**
 * @author Sumit Borhade
 * 
 * This class performs the filtration using the list of specified filters.
 * 
 */
public class FindDelimiterAndOperationalInput {

	private String defaultDelimiter;
	
	public FindDelimiterAndOperationalInput(String defaultDelimiter) {
		this.defaultDelimiter = defaultDelimiter;
	}
	
	public InputModel delimiterOrchestrator(String input) {
		if(input == null) {
			input = CalculatorConstants.EMPTY_STRING;
		}
		
		InputModel inputModel = extractRawDelimiters(input);
		String rawDelimiter = inputModel.getDelimiter();
		String operationalDelimiter = GenericUtils.escapeMetaCharacters(rawDelimiter);
		inputModel.setDelimiter(operationalDelimiter);
		return inputModel;
	}
	
	public InputModel extractRawDelimiters(String numbers) {
		String delimiter = defaultDelimiter;
		String operationalInput = numbers;
		
		Pattern pattern = Pattern.compile(CalculatorConstants.REGEX_DELIMITER_EXTRACTOR);
		Matcher matcher = pattern.matcher(numbers);
		while (matcher.find()) {
			delimiter = matcher.group(1);
			operationalInput = numbers.replaceFirst(CalculatorConstants.REGEX_DELIMITER_EXTRACTOR, CalculatorConstants.EMPTY_STRING);
		}

		InputModel inputModel = new InputModel(delimiter, operationalInput);
		return inputModel;
	}
}