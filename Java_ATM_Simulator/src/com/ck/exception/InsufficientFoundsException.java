package com.ck.exception;
/**
 * Thrown when the passed amount is greater than current balance
 * 
 * @author Roumya
 * @since 1.0
 * @see NegativeAmountException
 */
public class InsufficientFoundsException extends Exception {

	private static final long serialVersionUID = 1L;

	public InsufficientFoundsException() {
		super();
	}

	public InsufficientFoundsException(String message) {
		super(message);
		
	}

}
