package com.ck.implementation;

import com.ck.Specification.ATMCard;
import com.ck.exception.InsufficientFoundsException;
import com.ck.exception.NegativeAmountException;

public class SBIBankCard implements ATMCard {
	
	private long accNum;
	private String acchNum;
	private double balance;
	
	static {
		System.out.println("SBIBankCard is loaded");
	}

	public SBIBankCard(long accNum, String acchNum, double balance) {
		this.accNum = accNum;
		this.acchNum = acchNum;
		this.balance = balance;
		System.out.println("SBIBankCard object is created");
	}

	@Override
	public String deposit(double amt) throws NegativeAmountException {
		
		if(amt<=0)
			throw new NegativeAmountException("Don't pass Zero or -ve amount");
			
		this.balance = this.balance +amt;
		return amt + " is credited to "+ accNum + "\n avalible balance in SBIBankCard is " +balance;
	}

	@Override
	public String withdraw(double amt) throws NegativeAmountException, InsufficientFoundsException {
		
		if(amt<=0)
			throw new NegativeAmountException("Don't pass Zero or -ve amount");
			
		if(amt>balance)
			throw new InsufficientFoundsException("Insufficent found");
		
		this.balance = this.balance +amt;
		return amt + " is debited from "+ accNum + "\n avalible balance in SBIBankCard is " + balance;
	}

	@Override
	public void currentBalance() {
		System.out.println("Current balance in SBIBankCard is" +balance);

	}

	@Override
	public String toString() {
		return "SBIBankCard [accNum=" + accNum + ", acchNum=" + acchNum + ", balance=" + balance + "]";
	}
	

}
