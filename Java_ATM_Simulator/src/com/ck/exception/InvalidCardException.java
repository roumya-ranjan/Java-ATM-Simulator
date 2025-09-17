package com.ck.exception;

public class InvalidCardException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidCardException() {
		super();
	}

	public InvalidCardException(String message) {
		super(message);
	}

}
