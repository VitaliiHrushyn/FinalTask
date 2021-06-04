package com.alpha.controller.exception;

public abstract class ValidationException extends Exception {
	public ValidationException() {
	}

	public ValidationException(String message) {
		super(message);
	}
}
