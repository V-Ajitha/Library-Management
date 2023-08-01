package com.library;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class User extends Details{

	private Map<String,Integer> orderedDetails = new LinkedHashMap<>();
	Scanner scan = new Scanner(System.in);
	
	public User(String name,int age,String email,String pass,String address) {
		super(name,age,email,pass,address);
	}
	public void addorderedDetails(String orderedBook,int quantity) {
		orderedDetails.put(orderedBook, quantity);
	}
	public int getTotalBookCount() {
		int bookCount = 0;
		for(String name:orderedDetails.keySet()) {
			bookCount += orderedDetails.get(name);
		}
		return bookCount;			
	}
	
	  public void enterShippingInfo() {
	        System.out.println("Enter shipping information:");

	        System.out.print("First Name: ");
	        String Name = scan.nextLine();
	        

	        System.out.print("Address Line : ");
	        String addressLine = scan.nextLine();

	        System.out.print("City: ");
	        String city = scan.nextLine();

	        System.out.print("State: ");
	        String state = scan.nextLine();

	        System.out.print("Postal Code: ");
	        String postalCode = scan.nextLine();

	        System.out.print("Country: ");
	        String country = scan.nextLine();
	        System.out.println("Shipping information entered.");
	    }
	  public void enterBillingInfo() {
	    	System.out.println();
	        System.out.println("Enter billing information:");

	        System.out.print("Cardholder Name: ");
	        String cardholderName = scan.nextLine();

	        System.out.print("Card Number: ");
	        String cardNumber = scan.nextLine();
	        System.out.println("Billing information entered.");
	    }
}
