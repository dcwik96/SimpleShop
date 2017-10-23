package com.example.shop.service;

import com.example.shop.domain.Book;

import java.util.HashMap;
import java.util.Map;

public class KoszykService {

    private int id = 0;
    private Map<Integer, Book> db = new HashMap<Integer, Book>();

    public void add(Book book) {
        Book newBook = new Book(book.getTitle(), book.getAuthor(), book.getPrize(), book.getAmount());
        db.put(id, newBook);
        id++;
    }

    public Map<Integer, Book> getAllBooks(){
        return db;
    }
}
