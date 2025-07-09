package com.bookstore;

import java.time.LocalDate;

public abstract class Book {
    private String ISBN;
    private String title;
    private String author;
    private double price;
    private LocalDate publishedyear;



    public  Book(String ISBN, String title, String author, double price, LocalDate publishedyear) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
        this.publishedyear = publishedyear;

    }

    public String getISBN() {
        return this.ISBN;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPublishedyear() {
        return this.publishedyear;
    }


}
