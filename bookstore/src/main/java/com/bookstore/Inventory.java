package com.bookstore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map <Book, Integer> library; // Map to hold books and their quantities
    public Inventory() {
        this.library = new HashMap<>();
    }

    public void addBook(Book book, int quantity) {
            if (quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than zero.");
            }else if (book == null) {
                throw new IllegalArgumentException("Book cannot be null.");
            }else{
                if (library.containsKey(book)) {
                library.put(book, library.get(book) + quantity);
                } else {
                library.put(book, quantity);
            }
            }

    }

    public void buyBook(Book book, int quantity){
        library.put(book, library.get(book) - quantity);
    }

    public int getQuantity(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        return library.getOrDefault(book, 0);
    }

    public void setQuantity(Book book, int quantity) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        library.put(book, quantity);
    }

    public Book [] getOutdatedBooks(LocalDate year){
        if (year == null) {
            throw new IllegalArgumentException("Year cannot be null.");
        }

        ArrayList<Book> outdatedBooks = new ArrayList<>();
        library.forEach((book, quantity) -> {
            if (book.getPublishedyear().minusYears(LocalDate.now().getYear()) == year) {
                outdatedBooks.add(book);
                library.remove(book);
            }
        });
       
        
        return outdatedBooks.toArray(new Book[0]);
    }




}
