package com.ck.user;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ck.Specification.ATMCard;
import com.ck.exception.InsufficientFoundsException;
import com.ck.exception.InvalidCardException;
import com.ck.exception.NegativeAmountException;

public class ATM {

	public void insertCard(String cardName)
						throws InvalidCardException{
		Scanner scn = new Scanner(System.in);
		try {
			//Reflection API for loading and instantiating given card class dynamically for achieving LC and RP
			
			//Loading the given ATMcard's class
			Class cls = Class.forName(cardName);
		
			//Instantiating the given ATMCard class
			//Object obj = cls.newInstance();
			
			Constructor paramConstructor = cls.getDeclaredConstructor(long.class, String.class, double.class);
			Object obj = paramConstructor.newInstance(1234, "CK", 10000);
		
			//checking whether the loaded class is ATMCard type or not
			if(!(obj instanceof ATMCard)) {
				throw new InvalidCardException(cardName+"is not ATMCard type");
			}
			
			//ATM business operation logic is going on
			ATMCard card = (ATMCard)obj;
			
			loop:while(true) {
				System.out.println("\nChoose one option");
				System.out.println(" 1. Deposit");
				System.out.println(" 2. Withdraw");
				System.out.println(" 3. Check balance");
				System.out.println(" 4. Exit");
				
				int option ;
				while(true) {
					try {
						System.out.print("\nEnter option: ");
						option = scn.nextInt(); scn.nextLine();
						break;
					}catch(InputMismatchException e) {
						scn.nextLine();
						System.out.println("Error: Enter only integer");
					}
				}//while close
				
				switch(option) {
					case 1: //deposit
						while(true) {
							try {
								System.out.print("\nEnter amount: ");
								String message = card.deposit(scn.nextDouble());
								System.out.println(message);
								break;
							}catch(InputMismatchException e) {
								scn.nextLine();
								System.out.println("Error: Enter only number");
								
							} catch (NegativeAmountException e) {
								System.out.println("Error: "+ e.getMessage());
							}
						}//nested while close
						break;
						
					case 2: //withdraw
						while(true) {
							try {
								System.out.print("\nEnter amount: ");
								String message = card.withdraw(scn.nextDouble());
								System.out.println(message);
								break;
								
							}catch(InputMismatchException e) {
								scn.nextLine();
								System.out.println("Error: Enter only number");
								
							}catch (NegativeAmountException | InsufficientFoundsException  e) {
								System.out.println("Error: "+ e.getMessage());
							}
						}//nested while close
						break;
	
					case 3: //Check balance
						card.currentBalance();
						break;
						
					case 4: 
						System.out.println("Thank you_/\\_ Visit Again");
						break loop;
						
					default:	
						System.out.println("Error: Invalid option");
				}//switch
				
			}//while
	
			
		}catch (ClassNotFoundException e) {
			throw new InvalidCardException(cardName + ".class is not found"); 
			
		}catch (InstantiationException e) {
			throw new InvalidCardException("No-param constructor "+cardName+ "() is not found");
			
		}catch(IllegalAccessException e) {
			throw new InvalidCardException("No-param constructor is not public");
			
		}catch(NoSuchMethodException e1) {
			throw new InvalidCardException("Param constructor is not available");
			
		}catch (InvocationTargetException e1) {
			throw new InvalidCardException("Param constructor is not available");
			
		}
	}
}
