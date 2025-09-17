package com.ck.Specification;

import com.ck.exception.InsufficientFoundsException;
import com.ck.exception.NegativeAmountException;

/**
 * provides specification for implementing an ATM Card by any Bank
 * 
 * @author Roumya
 * @since 1.0
 */
public interface ATMCard {
	
	/**
	 * deposits the given amount in the card account
	 *  
	 * @param amt the amount to deposit
	 * @return String balance details
	 * @throws NegativeAmountException if the passed amount is -ve number
	 */
	public String deposit(double amt)
				throws NegativeAmountException;
	
	/**
	 * withdraw the given amount in the card account
	 *  
	 * @param amt the amount for withdraw
	 * @return String balance details after withdraw
	 * @throws NegativeAmountException if amount is -ve number
	 * @throws InsufficientFoundsException if amount is greater than balance
	 * 
	 */
	
	public String withdraw(double amt)
				throws NegativeAmountException,InsufficientFoundsException;
	
	/**
	 * prints this card's current balance
	 * 
	 */
	public void currentBalance();
}
