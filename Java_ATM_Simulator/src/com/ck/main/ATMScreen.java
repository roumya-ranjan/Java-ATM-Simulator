package com.ck.main;

import java.util.Scanner;

import com.ck.exception.InvalidCardException;
import com.ck.user.ATM;

public class ATMScreen {

	public static void main(String [] args) {
		Scanner scn = new Scanner (System.in);
		
		ATM atm = new ATM();
		while(true) {
			System.out.println("\nInsert card: ");
			
			try {
				atm.insertCard(scn.next());
				
			}catch (InvalidCardException e) {
				System.out.println("Error:" + e.getMessage());
			}
		}
	}	

}
