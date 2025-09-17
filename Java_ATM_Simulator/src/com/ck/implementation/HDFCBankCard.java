package com.ck.implementation;

import com.ck.Specification.ATMCard;
import com.ck.exception.InsufficientFoundsException;
import com.ck.exception.NegativeAmountException;

public class HDFCBankCard implements ATMCard {
	
	private long accNum;
	private String acchNum;
	private double balance;
	
	static {
		System.out.println("HDFCBankCard is loaded");
	}

	public HDFCBankCard(long accNum, String acchNum, double balance) {
		this.accNum = accNum;
		this.acchNum = acchNum;
		this.balance = balance;
		System.out.println("HDFCBankCard object is created");
	}

	@Override
	public String deposit(double amt) throws NegativeAmountException {
		
		if(amt<=0)
			throw new NegativeAmountException("Don't pass Zero or -ve amount");
			
		this.balance = this.balance +amt;
		return amt + " is credited to "+ accNum + "\n avalible balance in HDFCBankCard is " +balance;
	}

	@Override
	public String withdraw(double amt) throws NegativeAmountException, InsufficientFoundsException {
		
		if(amt<=0)
			throw new NegativeAmountException("Don't pass Zero or -ve amount");
			
		if(amt>balance)
			throw new InsufficientFoundsException("Insufficent found");
		
		this.balance = this.balance +amt;
		return amt + " is debited from "+ accNum + "\n avalible balance in HDFCBAnkCard is " + balance;
	}

	@Override
	public void currentBalance() {
		System.out.println("Current balance in HDFCBankCArd is" +balance);

	}

	@Override
	public String toString() {
		return "HDFCBankCard [accNum=" + accNum + ", acchNum=" + acchNum + ", balance=" + balance + "]";
	}
	

}
