package com.ubs.calculator.service;

import java.util.List;

import com.ubs.calculator.exception.GenericAddException;

public interface IValidationRule {

	public void isInputValid(List<Integer> numbers) throws GenericAddException;
}
