package com.library;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ShoppingCart{
	int soldViewCartItems;
	int updatedQuantity;
	private Map<String, Integer> items = new LinkedHashMap<>();
	BookManagement management = new BookManagement();

	public void addItem(String bookName,int quantity) {
		
		items.put(bookName,quantity);
		System.out.println("Book added successfully");
	}
	public void removeItem(String bookName) {
		if(items.containsKey(bookName)) {
			items.remove(bookName);
			System.out.println("Book deleted successfully");
		}
		else {
			System.out.println(bookName+" is not available in this cart");
		}
		
	}	
	public Set<String> returnKeySet() {
		return items.keySet();
	}
	public int getCartQuantity(String bookName) {
		return items.get(bookName);
	}
	public void clearCart() {
	    items.clear();
	}
}















//public void setCartQuantity(int cartQuantity) {
//	this.cartQuantity = cartQuantity;
//}


//int soldBooks;
//int soldViewCartItems;	
//public int noOfViewCartsBooksSold() {
//	return items.size();
//}
//public void noOfBooksSold(int soldSelectedBooks){
//	 soldBooks = soldSelectedBooks + soldViewCartItems;
//	 System.out.println("Total Number of Books Sold:"+ soldBooks);
//}

//public void noOfBooksSold(int selectedQuantity) {
//int soldQuantity = soldViewCartItems + selectedQuantity;
//System.out.println("Total Number of Books Sold:"+ soldQuantity);
//}

//public boolean isBookExist(String bookName) {
//return items.containsKey(bookName);
//}
//public void decreaseQuantity(String bookName,int quantity) {
//int currentQuantity = items.get(bookName);
//if (currentQuantity > 0) {
//	updatedQuantity =  currentQuantity - quantity;
//	items.put(bookName,updatedQuantity);
//} else {
//    System.out.println("Book is out of stock.");
//}
//}
