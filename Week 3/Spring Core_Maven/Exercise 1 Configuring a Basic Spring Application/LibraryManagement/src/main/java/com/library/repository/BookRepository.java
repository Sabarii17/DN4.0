package com.library.repository;

public class BookRepository {
    public void saveBook(String bookName) {
        System.out.println("Function from Repository class");
        System.out.println("Book saved: " + bookName);
    }
}
