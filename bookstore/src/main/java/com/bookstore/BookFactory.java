package com.bookstore;

import java.time.LocalDate;

public class BookFactory {
    
    public static Book createPaperBook(String ISBN, String title, String author, double price, LocalDate publishedyear, int quantity) {
        return new PaperBook(ISBN, title, author, price, publishedyear, quantity);
    }

    public static Book createEBook(String ISBN, String title, String author, double price, LocalDate publishedyear, String fileType) {
        return new EBook(ISBN, title, author, price, publishedyear, fileType);
    }

    public static Book createShowcaseBook(String ISBN, String title, String author, LocalDate publishedyear) {
        return new ShowcaseBook(ISBN, title, author, publishedyear);
    }
}

