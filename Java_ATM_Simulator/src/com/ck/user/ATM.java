package com.ck.user;

import com.ck.Specification.ATMCard;
import com.ck.exception.InvalidCardException;

public class ATM {

	public void insertCard(String cardName)
						throws InvalidCardException{
		
		try {
			//Loading the given ATMcard's class
			Class cls = Class.forName(cardName);
		
			//Instantiating the given ATMCard class
			Object obj = cls.newInstance();
		
			//checking whether the loaded class is ATMCard type or not
			if(!(obj instanceof ATMCard)) {
				throw new InvalidCardException(cardName+"is not ATMCard type");
			}
			
			//blogic is going on
			ATMCard card = (ATMCard)obj;
			card.deposit(amt);
			card.withdraw(amt);
			card.currentBalance();
			
		}catch (ClassNotFoundException e) {
			throw new InvalidCardException(cardName + ".class is not found"); 
			
		}catch (InstantiationException e) {
			throw new InvalidCardException("No-param constructor "+cardName+ "() is not found");
			
		}catch(IllegalAccessException e) {
			throw new InvalidCardException("No-param constructor is not public");
		}
	}
}
