package com.ubs.calculator.util;

/**
 * @author Sumit Borhade
 * 
 * This class provides the generic utility methods.
 * 
 */
public class GenericUtils {

	/**
	 * @param inputString
	 * @return
	 * 
	 * This  method enriches the input with escape character if input contains dangling characters.
	 * 
	 */
	public static String escapeMetaCharacters(String inputString) {
		final String[] metaCharacters 
			= { "\\", "^", "$", "{", "}", "[", "]", "(", ")", ".", "*", "+", "?", "<", ">", "-", "&", "%" };

		for (int i = 0; i < metaCharacters.length; i++) {
			if (inputString.contains(metaCharacters[i])) {
				inputString = inputString.replace(metaCharacters[i], "\\" + metaCharacters[i]);
			}
		}
		return inputString;
	}

}
