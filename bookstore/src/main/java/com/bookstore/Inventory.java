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
            }
            else if(book.getClass() ==  EBook.class){
                library.put(book, Integer.MAX_VALUE);
            }
            else if (book.getClass() ==  ShowcaseBook.class){
                library.put(book, 1);
            }
                
            else{
                if (library.containsKey(book)) {
                library.put(book, library.get(book) + quantity);
                } else {
                library.put(book, quantity);
            }
            }

    }

    public void buyBook(Book book, int quantity){
        if (book == null){
            throw new IllegalArgumentException("Book cannot be null.");
        
        }
        else if (book.getClass() ==  EBook.class){
            throw new IllegalArgumentException("Cannot decide quantity of an Ebook. Call again without identifying quantity.");
        }
        else if (book.getClass() ==  ShowcaseBook.class){
            throw new IllegalArgumentException("Cannot buy a Showcase/Demo Book.");
        }
        else{
            library.put(book, library.get(book) - quantity);
        }
       
    }

    public void buyBook(Book book){
        if (book.getClass() !=  EBook.class){
            throw new IllegalArgumentException("Book is not Ebook so must provide quantity.");
        }
    }

    public int getQuantity(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if(book.getClass() ==  EBook.class){
            return Integer.MAX_VALUE;
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
