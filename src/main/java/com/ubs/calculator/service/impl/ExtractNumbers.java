package com.ubs.calculator.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ubs.calculator.model.InputModel;
import com.ubs.calculator.service.IExtractNumbers;

public class ExtractNumbers implements IExtractNumbers {

	public List<Integer> extractNumbers(InputModel inputModel) {
		List<Integer> numbersList = new ArrayList<Integer>();
		Scanner scanner = new Scanner(inputModel.getOperationalInput());
		
		try {
			scanner.useDelimiter(inputModel.getDelimiter());
			
			while(scanner.hasNext()) {
				numbersList.add(Integer.parseInt(scanner.next()));
			}
			
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}
		return numbersList;
	}

}