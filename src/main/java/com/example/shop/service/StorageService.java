package com.example.shop.service;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.example.shop.domain.Book;

public class StorageService {

	private int id = 0;
	private Map<Book, Integer> db = new Map<Book, Integer>(){
		public int size() {
			return 0;
		}

		public boolean isEmpty() {
			return false;
		}

		public boolean containsKey(Object key) {
			return false;
		}

		public boolean containsValue(Object value) {
			return false;
		}

		public Integer get(Object key) {
			return null;
		}

		public Integer put(Book key, Integer value) {
			return null;
		}

		public Integer remove(Object key) {
			return null;
		}

		public void putAll(Map<? extends Book, ? extends Integer> m) {
			
		}

		public void clear() {
			
		}

		public Set<Book> keySet() {
			return null;
		}

		public Collection<Integer> values() {
			return null;
		}

		public Set<java.util.Map.Entry<Book, Integer>> entrySet() {
			return null;
		}
	};
	
	public void add(Book book) {
		Book newBook = new Book(book.getTitle(), book.getAuthor(), book.getPrize());
		db.put(newBook, id);
		id++;
	}

	public Map<Book, Integer> getAllBooks(){
		return db;
	}

}
