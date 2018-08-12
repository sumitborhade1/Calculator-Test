package com.ubs.calculator.exception;

/**
 * @author Sumit Borhade
 *
 * This is exception is used in the application when input contains negative numbers.
 * 
 */
public class NegativeNumbersPresentException extends GenericAddException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public NegativeNumbersPresentException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}
