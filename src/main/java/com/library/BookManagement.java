package com.library;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BookManagement {
    private Map<String, Book> books;
    Scanner scan = new Scanner(System.in);

    public BookManagement() {
        books = new LinkedHashMap<>();
        Book book1 = new Book("book1","author1","desc1",10,10,"cat1");
        Book book2 = new Book("book2","author2","desc2",20,20,"cat2");
        Book book3 = new Book("book3","author3","desc3",30,10,"cat3");

        addBook("book1", book1);
        addBook("book2", book2);
        addBook("book3", book3);
    }
    
    public void totalNoOfBooks() {
    	System.out.println("TotalNoOfBooks:"+books.size());
    }
    public void addBook(String title, Book book) {
        books.put(title, book);
    }

    public void deleteBook(String title) {
        books.remove(title);
    }    
    public void viewAllBooks() {
        for (Book book : books.values()) {
        	System.out.println();
            System.out.println("Title: " + book.getTittle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Description: " + book.getDescription());
            System.out.println("Price: $" + book.getPrice());
            System.out.println("Quantity:"+book.getQuantity());
            System.out.println("Category: " + book.getCategory());
            System.out.println("-------------------------");
        }
    }
    public void addNewBooks() {
		System.out.print("Enter a Tittle:");
		String bookName = scan.nextLine();
		System.out.print("Enter a Author:");
		String bookAuthor = scan.nextLine();
		System.out.print("Enter a Description:");
		String bookDescription = scan.nextLine();
		System.out.print("Enter a Price:");
		double bookPrice = scan.nextDouble();
		scan.nextLine();
		System.out.print("Enter a Quantity:");
		int bookQuantity = scan.nextInt();
		scan.nextLine();
		System.out.print("Enter a Category:");
		String bookCategory = scan.nextLine();
		Book bookObj = new Book(bookName,bookAuthor,bookDescription,bookPrice,bookQuantity,bookCategory);
		
		System.out.println("Book added successfully");
    	
        System.out.println("Updated book details:");

        addBook(bookName,bookObj);
        viewAllBooks();
    }
    public void deleteMethod() {
		  	System.out.println("Enter Book Id you want to delete:");
			String deleteBook = scan.nextLine();
			deleteBook(deleteBook);
			System.out.println("Book deleted successfully");
	  }
    public void searchBook(String tittle) {        
    		if(books.containsKey(tittle)) {
    			Book book = books.get(tittle);
    			System.out.print("Tittle:"+book.getTittle());
    			System.out.print(", Author:"+book.getAuthor());
    			System.out.print(", Description:"+book.getDescription());
    			System.out.print(", Price: $"+book.getPrice());
    			System.out.print(", Quantity:"+book.getQuantity());
    			System.out.println(", Catagory:"+book.getCategory());
    		}
    		else {
    			System.out.println("------No Book found -------------");
    		}
    		
    	}
    public Book getBook(String bookName) {
    	return books.get(bookName);
    }
    public boolean checkQuantity(int quantity) {
    	for (Book book : books.values()) {
    		if(book.getQuantity() > quantity) {
    			return true;
    		}
    	}
    	return false;
    }
}
