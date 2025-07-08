package com.bookstore;

import java.time.LocalDate;

public class ShowcaseBook extends Book {

     public ShowcaseBook(String ISBN, String title, String author, LocalDate publishedyear) {
        super(ISBN, title, author, 0.0, publishedyear);

     }

    @Override
    public double getPrice() {
        return 0.0;
    }
}
