package com.bookstore;

public class CustomerFactory {
     private static int nextId = 1;  

    public static Customer createCustomer (String name, String email, String phoneNumber, String address, int balance) {
        Customer customer;
        try{
            customer = new Customer(name, email, phoneNumber, address, balance, nextId);
          
        }
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid customer details provided.");
        }
        nextId++;
        return customer;
    }
}
