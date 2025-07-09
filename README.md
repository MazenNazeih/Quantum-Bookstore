# Quantum Bookstore

Welcome to **Quantum Bookstore**, a demo Java application simulating an advanced bookstore with different book types and customer purchasing logic.

---

##  Features

- Supports **three types of books**:
  - Paper books (with stock & ShippingService)
  - EBooks (sent via email)
  - Showcase books (demo only, not for sale)
- Customer creation and balance management
- Inventory stock management
- Shipping and email services
- Exception handling for invalid operations

---

## Technologies used

- Java (17 or above)
- Maven
- Object-oriented design 
- VS Code 

---

## Project Structure

```plaintext

src/main/java/com/bookstore/

├── App.java                 → Entry point with main method to demonstrate features
├── Book.java                → Abstract base class for all book types
├── BookFactory.java         → Factory class to create different types of books
├── PaperBook.java           → Subclass representing a physical paper book
├── EBook.java               → Subclass representing an electronic book
├── ShowcaseBook.java        → Subclass representing a non-sellable demo book
├── Customer.java            → Represents a customer (name, email, balance, etc.)
├── CustomerFactory.java     → Factory to create customers with unique IDs
├── Inventory.java           → Manages available books and stock
├── MailService.java         → Simulates sending eBooks via email
└── ShippingService.java     → Simulates shipping physical books

```



##  How it works
1- Inventory initialized with three book types.

2- A customer is created with an initial balance.

3- Customer buys paper book, stock decreases, and shipping message appears.

4- Customer buys eBook, email is sent.

5- Attempt to buy a showcase book → correctly throws an error.

6- Final balance and stock levels are printed.

## Sample Output

![Bookstore Output Screenshot](Images/Bookstore-Output-Screenshot.png)


```
=== Welcome to Quantum Bookstore ===

--- Inventory ---
Quantum Demo Book (ShowcaseBook) :  $0.0 | Stock: 1
Quantum Paper Book (PaperBook) :  $50.0 | Stock: 5
Quantum E-Book (EBook) :  $25.0 | Stock: 2147483647

Customer created: Mazen, Balance: $1000.0

Successfully bought 2 x Quantum Paper Book for $100.0
Shipping Quantum Paper Book to 123 Street

Successfully bought 1 x Quantum E-Book for $25.0
Sending eBook Quantum E-Book to mazen@gmail.com

Error buying showcase book: Cannot buy a demo book

--- Final Customer Balance ---
Mazen now has $875.0

--- Remaining PaperBook Stock ---
Quantum Paper Book stock left: 3

Thank you for shopping with us!
```

## How to Run
- Navigate to \Bookstore\Quantum-Bookstore\bookstore> then excute the following code in powershell:
  
```powershell
# Compile
mvn clean compile

# Run
mvn exec:java '-Dexec.mainClass=com.bookstore.App'
```

