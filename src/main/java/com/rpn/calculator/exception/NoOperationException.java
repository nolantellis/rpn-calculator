package com.rpn.calculator.exception;

public class NoOperationException extends Exception {
	String message;

	public NoOperationException(String message) {
		super(message);
		this.message = message;
	}

}
