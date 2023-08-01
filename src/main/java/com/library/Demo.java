package com.library;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {
    private static Map<String, User> users = new HashMap<>();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        SignupThread signupThread1 = new SignupThread();
        SignupThread signupThread2 = new SignupThread();

        signupThread1.start(); // Start the first signup thread
       // signupThread2.start(); // Start the second signup thread
    }

    static class SignupThread extends Thread {
        @Override
        public void run() {
            signUp();
        }

        private void signUp() {
            System.out.print("Enter a User Name: ");
            String name = scan.nextLine();
            System.out.print("Enter an age: ");
            int age = scan.nextInt();
            scan.nextLine();
            System.out.print("Enter a User Email: ");
            String email = scan.nextLine();
            System.out.print("Enter a password: ");
            String pass = scan.nextLine();
            System.out.print("Enter a User Address: ");
            String address = scan.nextLine();

            synchronized (users) {
                if (!users.containsKey(email)) {
                    users.put(email, new User(name, age, email, pass, address));
                    System.out.println("Signup successfully for " + email);
                } else {
                    System.out.println("Email already exists: " + email);
                }
            }
        }
    }

    static class User {
        private String name;
        private int age;
        private String email;
        private String password;
        private String address;

        public User(String name, int age, String email, String password, String address) {
            this.name = name;
            this.age = age;
            this.email = email;
            this.password = password;
            this.address = address;
        }
    }
}







































//public class Demo {
//    public static void main(String[] args) {
//        SignupThread signupThread1 = new SignupThread("John", "Doe");
//        SignupThread signupThread2 = new SignupThread("Jane", "Smith");
//
//        signupThread1.start(); // Start the first signup thread
//        signupThread2.start(); // Start the second signup thread
//    }
//}
//
//class SignupThread extends Thread {
//    private String firstName;
//    private String lastName;
//
//    public SignupThread(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    @Override
//    public void run() {
//        performSignup();
//    }
//
//    private void performSignup() {
//        // Code for performing signup process
//        System.out.println("Signing up " + firstName + " " + lastName);
//        // ...
//    }
//}
















//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class Demo {
//	
//	public static void main(String[] args) {
//		Map<String, Integer> demoMap = new LinkedHashMap<>();
//		demoMap.put("aa", 1);
//		demoMap.put("bb", 2);
//		demoMap.put("cc", 3);
//		System.out.println(demoMap.keySet());
//	}
//}
