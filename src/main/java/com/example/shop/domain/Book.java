package com.example.shop.domain;

public class Book {
	private String title = "unknown";
	private String author = "unknown";
	private double prize = 0.0;
	private int amount =1;
	
	public Book() {
		super();
	}



	public Book(String title, String author, double prize, int amount) {
		super();
		this.title = title;
		this.author = author;
		this.prize = prize;
		this.amount = amount;

	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrize() {
		return prize;
	}
	public void setPrize(double prize) {
		this.prize = prize;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void increaseAmount() { this.amount++; }

}
