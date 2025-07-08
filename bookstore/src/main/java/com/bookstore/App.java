package com.bookstore;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );

        // Creating cutomers
        try {  Customer customer1 = CustomerFactory.createCustomer("mazen", "mazen@gmail.com", "01234567890", "123 Street", 1000); 
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error while creating customer: " + e.getMessage());
        }
       
        try {
            double paidAmount = buyBook(null, null, 0, null);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error while buying a book: " + e.getMessage());
        }
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

        if (availableQuantity < quantity) {
            throw new IllegalArgumentException("Not enough stock available.");
        }

        double Cost = book.getPrice() * quantity;
        // balance check in customer class
        customer.buy(Cost);
       
        // Update inventory
        if (book.getClass() ==  PaperBook.class){
              inventory.buyBook(book, quantity);
        }
        else if (book.getClass() ==  EBook.class){
            inventory.buyBook(book);
        }
        else if( book.getClass() ==  ShowcaseBook.class){
            throw new IllegalArgumentException("Cannot buy a demo book");
        }
        return Cost; 
    }
}
