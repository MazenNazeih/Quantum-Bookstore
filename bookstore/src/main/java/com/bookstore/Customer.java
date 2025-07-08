package com.bookstore;

public class Customer {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private double balance;
    private int customerId;
    
    public Customer(String name, String email, String phoneNumber, String address, double balance, int customerId) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty.");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }
        if (phoneNumber == null || phoneNumber.length() != 11) {
            throw new IllegalArgumentException("Phone number must be exactly 11 digits.");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty.");
        }
        if (customerId <= 0) {
            throw new IllegalArgumentException("Customer ID must be a positive integer.");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.balance = balance;
        this.customerId = customerId;
        
    }

    // deduct price of book from balance and returns remaining balance
    public double buy(double cost){
        if (cost < 0) {
            throw new IllegalArgumentException("Cost cannot be negative.");
        }
        if (cost > getBalance()) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        this.balance -= cost;
        return this.balance;

    }

    public String getName() {
        return name;
    }

    public void rename(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 11) {
            throw new IllegalArgumentException("Phone number must be between 11 digits.");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
    }

    public int getCustomerId() {
        return customerId;
    }


}
