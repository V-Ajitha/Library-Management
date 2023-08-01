package com.library;

import java.util.Scanner;

public class OnlineMarketPlace extends Thread{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);        
        System.out.println("Welcome to the Online Bookstore!");
        
        Login login = new Login();
        
        
        boolean again = true;        
        try {
        	while (again) {
    		Thread.sleep(1000);
            System.out.println("1.Signin\n2.SignUp\n3.Login as an admin\n4.Login as an user\n5.Logout\n6.Exit");
            System.out.println("Please enter a number between 1 and 6:");
            int choice = scan.nextInt();
            scan.nextLine();
    	        if(choice == 1) {
    	        	 System.out.println("Are you new user? (y or n):");
    		            String option = scan.nextLine();
    		            if(option.equalsIgnoreCase("y")) {
    			            System.out.println("First SignUp here and then SignIn");
    		            	login.signUp();
    		            	System.out.println("SignIn Now..");
    		            	login.signIn();	
    		            }
    		            else if(option.equalsIgnoreCase("n")) {
    			            System.out.println("SignIn Here");
    		            	login.signIn();
    		            }
    		            else {
    		            	System.out.println("Enter a correct option");
    		            }
    	        }   
    	        else if(choice == 2) {
    	        		System.out.println("SignUp Here");
    		            login.signUp();
    		            System.out.println("SignIn Here");
    	            	login.signIn();
    	        }  
    	    	 else if(choice == 3) {
    	    		
    	    		 login.signIn();
    	        }
    	    	 else if(choice == 4) {
    	    		 
    	    		 login.signIn();
    	        }
            	 else if(choice == 5) {
            		 System.out.println("Logged Out Successfully..");
            		 again = false;
     	        }
             	 else if(choice == 6) {
              		 System.out.println("Thanks for visiting..! ");
              		 again = false;
       	        }
             	 else {
             		 System.out.println("Invalid choice. Please try again.");
             	}
            }
        }catch(InterruptedException ee) {
        	System.out.println(ee);
        }
        finally {
        	scan.close();
        }
    }
}
