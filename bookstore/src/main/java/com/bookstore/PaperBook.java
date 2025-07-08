package com.bookstore;

import java.time.LocalDate;

public class PaperBook extends Book{
     private int quantity;

    public PaperBook(String ISBN, String title, String author, double price, LocalDate publishedyear, int quantity) {
        super(ISBN, title, author, price, publishedyear);
        this.quantity = quantity;
    }

     public int getQuantity() {
        return this.quantity;
    }

}
