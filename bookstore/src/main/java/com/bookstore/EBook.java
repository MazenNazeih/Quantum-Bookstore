package com.bookstore;

import java.time.LocalDate;

public class EBook extends Book {
     private String fileType;

     public EBook(String ISBN, String title, String author, double price, LocalDate publishedyear, String fileType) {
        super(ISBN, title, author, price, publishedyear);
        this.fileType = fileType;
    }

     public String getFileType() {
        return this.fileType;
    }
}
