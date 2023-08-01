package com.library;

class Book {

	private String tittle;
	private String author;
	private String description;
	private double price;
	private int quantity;
	private String category;
	
	public Book(String tittle,String author,String description,double price,int quantity,String category) {
		this.tittle = tittle;
		this.author = author;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}
	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}











