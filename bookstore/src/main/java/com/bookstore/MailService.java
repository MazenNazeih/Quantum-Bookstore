package com.bookstore;

public class MailService {
    public static void sendEBook(Customer customer, Book book) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }

        // Simulate sending an eBook via email
        System.out.println("Sending eBook " + book.getTitle() + " to " + customer.getEmail());
    }
}
