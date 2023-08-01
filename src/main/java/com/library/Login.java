package com.library;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Login {
	Scanner scan = new Scanner(System.in);
	String email;
	String inEmail;
	String inPass;
	int totalRevenue;
	private Map<String, User> users = new LinkedHashMap<String, User>();

	BookManagement management = new BookManagement();
	ShoppingCart cart;
	
	public void signUp() {
		System.out.print("Enter a User Name:");
		String name = scan.nextLine();
		System.out.print("Enter a age:");
		int age = scan.nextInt();
		scan.nextLine();
		System.out.print("Enter a User Email:");
		email = scan.nextLine();
		System.out.print("Enter a password:");
		String pass = scan.nextLine();
		System.out.print("Enter a User Address:");
		String address = scan.nextLine();
		users.put(email, new User(name, age, email, pass, address));
		cart = new ShoppingCart();
		System.out.println("Signup successfully..");

	}
	public void signIn() {
		System.out.print("Enter your email:");
		String inEmail = scan.nextLine();
		System.out.print("Enter a password:");
		String inPass = scan.nextLine();
		if (users.containsKey(inEmail)) {
			User user = users.get(inEmail);
			if (user.getPass().equals(inPass)) {
				System.out.println("Logged in Successfully");
				System.out.println("Welcome User");
				boolean repeat1 = true;
				try {
					while (repeat1) {
						Thread.sleep(1000);
						System.out.println();
						System.out.println(
								"1.ViewBooks\n2.Search Books\n3.Add a book to the cart\n4.Remove books from the cart\n5.View Cart Items\n6.checkout\n7.Exit\nEnter a option:");
						int operation2 = scan.nextInt();
						scan.nextLine();
						if (operation2 == 1) {
							management.viewAllBooks();
						} else if (operation2 == 2) {
							System.out.println("Enter a book tittle you want to search:");
							String bookName = scan.nextLine();
							management.searchBook(bookName);
						} else if (operation2 == 3) {
							System.out.println("Enter a book tittle for add to cart:");
							String bookName = scan.nextLine();
							System.out.println("Enter a quantity you want:");
							int quantity = scan.nextInt();
							scan.nextLine();
							if (management.checkQuantity(quantity)) {
								cart.addItem(bookName, quantity);
							} else {
								System.out.println("Out of Stock");
							}

						} else if (operation2 == 4) {
							System.out.println("Enter a book tittle to remove from cart:");
							String bookName = scan.nextLine();
							cart.removeItem(bookName);

						} else if (operation2 == 5) {
							viewCartItems();
						} else if (operation2 == 6) {
							System.out.println("Cart Items:");
							viewCartItems();
							System.out.println();
							double totalPrice = calculateTotalPrice();
							System.out.println("Total Price: $" + totalPrice);
							startCheckout();

						} else if (operation2 == 7) {
							System.out.println("Thank You");
							repeat1 = false;
						}
					}
				} catch (InterruptedException ee) {
					System.out.println(ee);
				}
			}
		}
		if (inEmail.equals("A") && inPass.equals("A")) {
			System.out.println("Welcome Admin");
			boolean repeat2 = true;
			try {
				while (repeat2) {
					Thread.sleep(2000);
					System.out.println(
							"1.View Books\n2.Add Books\n3.Delete Books\n4.Total no of books\n5.total no of books sold\n6.no of books purchased by each user\n7.max number of books purchased by user\n8.min number of books purchased by user\n9.Total revenue made\n10.Exit\nEnter one option:");
					int operation = scan.nextInt();
					scan.nextLine();
					if (operation == 1) {
						management.viewAllBooks();
					} else if (operation == 2) {
						management.addNewBooks();
					} else if (operation == 3) {
						management.deleteMethod();
					} else if (operation == 4) {
						management.totalNoOfBooks();
					} else if (operation == 5) {
						displayTotalSoldBooks();
					} else if (operation == 6) {
						displayPurchesedBooks();
					} else if (operation == 7) {
						displayMaxPurchesedBook();
					} else if (operation == 8) {
						displayMinPurchesedBook();
					} else if (operation == 9) {
						totalRevenue();
					} else if (operation == 10) {
						System.out.println("Thank You");
						repeat2 = false;
					} else {
						System.out.println("Enter a correct option");
					}
				}
			} catch (InterruptedException ee) {
				System.out.println(ee);
			}
		}
//    	else {
//    		System.out.println("Wrong Email or Password");
//    	}    	

	}

	// for viewing all cart items from shopping cart
	public void viewCartItems() {
		Set<String> bookNames = cart.returnKeySet();
		if (bookNames.isEmpty()) {
			System.out.println("Your cart is Empty..");
		} else {
			for (String bookName : bookNames) {
				if (bookName.equals(null)) {
					System.out.println(bookName + "is not available");
				} else {
					Book book = management.getBook(bookName);
					System.out.print("Tittle:" + book.getTittle());
					System.out.print(", Author:" + book.getAuthor());
					System.out.print(", Price: $" + book.getPrice());
					System.out.println(", Quantity:" + cart.getCartQuantity(bookName));
				}

			}
		}
	}

	// calculating total price to get total revenue from cart items
	public double calculateTotalPrice() {
		Set<String> bookNames = cart.returnKeySet();
		double totalPrice = 0.0;
		for (String bookName : bookNames) {
			Book book = management.getBook(bookName);
			totalPrice += book.getPrice() * cart.getCartQuantity(bookName);
		}
		return totalPrice;
	}

	// calculating total price to get total revenue from user selected items
	public double selectedBooksTotalPrice(String bookName, int quantity) {
		double selectedBooksTotalPrice = 0.0;
		Book book = management.getBook(bookName);
		selectedBooksTotalPrice += book.getPrice() * quantity;
		return selectedBooksTotalPrice;
	}

	// payment checking for cart item
	private boolean processPayment(double amount) {
		double totalPrice = calculateTotalPrice();
		if (totalPrice > amount) {
			System.out.println("Entered amount not enough to buy");
			return false;
		} else if (amount >= totalPrice) {
			return true;
		} else {
			return true;
		}
	}
	// checkout process
	public void startCheckout() {
		System.out.println("Proceed to Checkout? (y/n)");
		String choice = scan.nextLine();
		if (choice.equalsIgnoreCase("y")) {
			System.out.println("Total payable amount: $" + calculateTotalPrice());
			User user = users.get(email);
			user.enterShippingInfo();
			user.enterBillingInfo();
			System.out.println();
			System.out.println("Enter a amount");
			int amount = scan.nextInt();
			scan.nextLine();
			boolean paymentSuccess = processPayment(amount);
			if (paymentSuccess) {
				addToOrderDetails(email);
				totalRevenue += amount;
				System.out.println("Checkout successful. Thank you for your purchase!");
				cart.clearCart();
			} else {
				System.out.println("Payment failed. Please try again or contact customer support.");
			}
		} else {
			System.out.println("Checkout cancelled.");
		}
	}

	public void totalRevenue() {
		System.out.println("TotalRevenue :$" + totalRevenue);
	}

	public void addToOrderDetails(String email) {
		Set<String> bookNames = cart.returnKeySet();
		User user = users.get(email);
		for (String bookName : bookNames) {
			user.addorderedDetails(bookName, cart.getCartQuantity(bookName));
		}
	}

	public void displayTotalSoldBooks() {
		int totalSoldBooks = 0;
		for (String email : users.keySet()) {
			User user = users.get(email);
			totalSoldBooks += user.getTotalBookCount();
		}
		System.out.println("Total no of books sold:" + totalSoldBooks);
	}

	public void displayPurchesedBooks() {
		for (String email : users.keySet()) {
			User user = users.get(email);
			System.out.println(user.getName() + " purchesed book : " + user.getTotalBookCount());
		}
	}

	public void displayMaxPurchesedBook() {
		int maxPurchesedBook = Integer.MIN_VALUE;
		User currentUser = null;
		for (String email : users.keySet()) {
			User user = users.get(email);
			if (user.getTotalBookCount() > maxPurchesedBook) {
				maxPurchesedBook = user.getTotalBookCount();
				currentUser = user;
			}
		}
		System.out.println("max number of books purchased :" + currentUser.getName());
	}

	public void displayMinPurchesedBook() {
		int minPurchesedBook = Integer.MAX_VALUE;
		User currentUser = null;
		for (String email : users.keySet()) {
			User user = users.get(email);
			if (user.getTotalBookCount() < minPurchesedBook) {
				minPurchesedBook = user.getTotalBookCount();
				currentUser = user;
			}
		}
		System.out.println("min number of books purchased :" + currentUser.getName());
	}
}












//public void noOfBooksSold2() {
//Set<String> bookNames = cart.returnKeySet();
//System.out.println(bookNames.size()); 
//}

//else if(operation == 6) {
////	System.out.println(email);
////	System.out.println(inEmail);
////	if (users.containsKey(email)){
////    	User user = users.get(email);
//////    	String userName = user.getName();
////		String bookName = order.getBookName();
////		int quantity = order.getQuantity();
//////		System.out.println("User Name: "+userName+", Purchesed Book Name: "+bookName+", Ordered Quantity"+quantity);
////		System.out.println("Purchesed Book Name: "+bookName+", Ordered Quantity"+quantity);
////	}else {
////		System.out.println("User name not found");
////	}
//	//String uString = inEmail;
//	
//	String userName = checkOutInfo.getName();
//	String bookName = order.getBookName();
//	int quantity = order.getQuantity();
//	System.out.println("User Name: "+userName+", Purchesed Book Name: "+bookName+", Ordered Quantity:"+quantity);
//	
//}
