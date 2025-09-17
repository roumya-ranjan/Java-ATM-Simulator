package com.ck.exception;

/**
 * Thrown when the passed amount is negative number
 * 
 * @author Roumya
 * @since 1.0
 * @see InsufficientFoundsException
 */
public class NegativeAmountException extends Exception {

	private static final long serialVersionUID = 1L;
	/**
	 * for creating exception object without error message
	 */
	public NegativeAmountException() {
		super();
	}
	/**
	 * for creating exception object with error message
	 * @param message error message for this exception
	 */
	public NegativeAmountException(String message) {
		super(message);
	}
}
