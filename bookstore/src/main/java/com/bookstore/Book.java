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
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPublishedyear() {
        return publishedyear;
    }


}
