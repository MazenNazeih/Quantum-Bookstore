package com.bookstore;

public class ShippingService {

    public static void shipPaperBook(Customer customer, Book book) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }

        // Simulate shipping process
        System.out.println("Shipping " + book.getTitle() + " to " + customer.getAddress());
    }
    
}
