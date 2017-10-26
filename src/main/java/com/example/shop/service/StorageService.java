package com.example.shop.service;

import java.util.*;

import com.example.shop.domain.Book;

public class StorageService {

	private int id = 0;
	private Map<Integer, Book> db = new HashMap<Integer, Book>();
	
	public void add(Book book) {
		if (!checkIfExists(book)){
			Book newBook = new Book(book.getTitle(), book.getAuthor(), book.getPrize(), book.getAmount());
			db.put(id, newBook);
			id++;
		}
	}

	public Map<Integer, Book> getAllBooks(){
		return db;
	}

	public Book findBookById(int id) {
		for (Map.Entry<Integer, Book> entry : db.entrySet()){
			if (entry.getKey() == id) {
				return entry.getValue();
			}
		}
		return null;
	}

	public void deleteAll(){
		db.clear();
	}

	private boolean checkIfExists(Book book) {
		for (Map.Entry<Integer, Book> entry : db.entrySet()) {
			if (entry.getValue().getTitle().equals(book.getTitle())) {
				if (entry.getValue().getAuthor().equals(book.getAuthor())) return true;
			}
		}
		return false;
	}
}
