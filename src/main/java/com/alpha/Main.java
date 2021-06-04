package com.alpha;

import com.alpha.controller.BooksController;
import com.alpha.controller.exception.InputIntValidationException;
import com.alpha.controller.exception.InputStringValidationException;
import com.alpha.controller.exception.PriceValidationException;

public class Main {
    public static void main(String[] args) throws InputStringValidationException, PriceValidationException, InputIntValidationException {
	     new BooksController().execute();
    }
}
