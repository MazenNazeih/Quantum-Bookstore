package com.bookstore;

import java.time.LocalDate;

public class App 
{
    public static void main(String[] args)
    {
        System.out.println("=== Welcome to Quantum Bookstore ===");

        Inventory inventory = new Inventory();

        // Creating books 
        PaperBook paperBook = (PaperBook) BookFactory.createPaperBook("978-1-23456-789-0", "Quantum Paper Book", "Dr. Wave", 50.0, LocalDate.of(2022, 1, 1), 5);
        EBook eBook = (EBook) BookFactory.createEBook("978-9-87654-321-0", "Quantum E-Book", "Dr. Photon", 25.0, LocalDate.of(2023, 5, 15), "PDF");
        ShowcaseBook showcaseBook = (ShowcaseBook) BookFactory.createShowcaseBook("978-1-11111-222-3", "Quantum Demo Book", "Dr. Demo", LocalDate.of(2021, 3, 10));

        // Adding books
        inventory.addBook(paperBook, paperBook.getQuantity());
        inventory.addBook(eBook);
        inventory.addBook(showcaseBook);

        System.out.println("\n--- Inventory ---");
        for (Book book : inventory.getBooks()) {
            System.out.println(book.getTitle() + " (" + book.getClass().getSimpleName() + ") :  $" + book.getPrice() + " | Stock: " + inventory.getQuantity(book));
        }

        // Create customer
        Customer customer1 = null;
        try {
            customer1 = CustomerFactory.createCustomer("Mazen", "mazen@gmail.com", "01234567890", "123 Street", 1000);
            System.out.println("\nCustomer created: " + customer1.getName() + ", Balance: $" + customer1.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Error while creating customer: " + e.getMessage());
            return; 
        }

        // Buy paper book
        try {
            double paidAmount = buyBook(customer1, paperBook, 2, inventory);
            System.out.println("\nSuccessfully bought 2 x " + paperBook.getTitle() + " for $" + paidAmount);
            ShippingService.shipPaperBook(customer1, paperBook);
        } catch (IllegalArgumentException e) {
            System.out.println("Error buying paper book: " + e.getMessage());
        }

        // Buy eBook
        try {
            double paidAmount = buyBook(customer1, eBook, 1, inventory);
            System.out.println("\nSuccessfully bought 1 x " + eBook.getTitle() + " for $" + paidAmount);
            MailService.sendEBook(customer1, eBook);
        } catch (IllegalArgumentException e) {
            System.out.println("Error buying eBook: " + e.getMessage());
        }

        // Try buying demo book
        try {
            double paidAmount = buyBook(customer1, showcaseBook, 1, inventory);
            System.out.println("\nSuccessfully bought 1 x " + showcaseBook.getTitle() + " for $" + paidAmount);
        } catch (IllegalArgumentException e) {
            System.out.println("\nError buying showcase book: " + e.getMessage());
        }

        // Final balance and stock
        System.out.println("\n--- Final Customer Balance ---");
        System.out.println(customer1.getName() + " now has $" + customer1.getBalance());

        System.out.println("\n--- Remaining PaperBook Stock ---");
        System.out.println(paperBook.getTitle() + " stock left: " + inventory.getQuantity(paperBook));

        System.out.println("\nThank you for shopping with us!");
    }


    
    public static double buyBook(Customer customer, Book book, int quantity, Inventory inventory) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        if (inventory == null) {
            throw new IllegalArgumentException("Inventory cannot be null.");
        }

        int availableQuantity = inventory.getQuantity(book);

        if (book instanceof PaperBook) {
            if (availableQuantity < quantity) {
                throw new IllegalArgumentException("Not enough stock available.");
            }
        }

        double cost = book.getPrice() * quantity;
        customer.buy(cost);

        // Update inventory
        if (book instanceof PaperBook) {
            inventory.buyBook(book, quantity);
        } else if (book instanceof EBook) {
            inventory.buyBook(book);
        } else if (book instanceof ShowcaseBook) {
            throw new IllegalArgumentException("Cannot buy a demo book");
        }
        return cost;
    }
}
