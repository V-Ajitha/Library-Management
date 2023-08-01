package com.library;

public class Details {
	
	private String name;
	private int age;
	private String email;
	private String pass;
	private String address;
	public Details(String name,int age,String email,String pass,String address) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.pass = pass;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getEmail() {
		return email;
	}
	public String getPass() {
		return pass;
	}
	public String getAddress() {
		return address;
	}	
}
