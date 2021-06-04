package com.alpha.controller;

import com.alpha.controller.exception.*;

public class BookValidator {
	public static void validateFindParam(String param) throws FindParamValidationException {
		if (param.isEmpty() || param.length() < 3) {
			throw new FindParamValidationException();
		}
	}

	public static void validatePriceChange(int percents) throws PriceChangeValidationException {
		if (percents == 0 ) {
			throw new PriceChangeValidationException();
		}
	}

	public static void validateInputString(String string) throws InputStringValidationException {
		if (string.isEmpty()) {
			throw new InputStringValidationException(); //("value can not be empty");
		}
	}

	public static void validateInputInt(int number) throws InputIntValidationException {
		if (number < 0) {
			throw new InputIntValidationException(); //("Value can not be negative");
		}
	}

	public static void validatePrice(double price) throws PriceValidationException {
		if (price < 0) {
			throw new PriceValidationException(); //("Price can not be a negative value");
		}
	}
}
