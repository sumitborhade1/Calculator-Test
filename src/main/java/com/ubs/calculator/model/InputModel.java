package com.ubs.calculator.model;

public class InputModel {

	private String delimiter;
	
	private String operationalInput;

	public InputModel(String delimiter, String operationalInput) {
		this.delimiter = delimiter;
		this.operationalInput = operationalInput;
	}

	public String getDelimiter() {
		return delimiter;
	}

	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

	public String getOperationalInput() {
		return operationalInput;
	}

	/*public void setOperationalInput(String operationalInput) {
		this.operationalInput = operationalInput;
	}*/
	
}