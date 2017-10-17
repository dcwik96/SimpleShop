package com.example.shop.domain;

public class Book {
	private String title = "unknown";
	private String author = "unknown";
	private double prize = 0.0;
	
	public Book() {
		super();
	}
	
	public Book(String title, String author, double prize) {
		super();
		this.title = title;
		this.author = author;
		this.prize = prize;
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
	
	
}
