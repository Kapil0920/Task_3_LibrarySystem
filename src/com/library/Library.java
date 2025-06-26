package com.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    
    // Scanner object to read user input
    static Scanner sc = new Scanner(System.in);

    // List to store all books in the library
    private List<Book> listBook;

    // List to store all registered users
    private List<User> listUser;

    // Constructor initializes the book and user lists
    public Library() {
        listBook = new ArrayList<Book>();
        listUser = new ArrayList<User>();
    }

    // Adds a new book to the library
    public void addBook(Book book) {
        listBook.add(book);
    }

    // Adds a new user to the library
    public void addUser(User user) {
        listUser.add(user);
        // Show the user's ID for reference
        System.out.println("Your id is: " + user.getUserId());
    }

    // Searches for a book in the list by its ID
    private Book findBookById(int bookId) {
        for (Book b : listBook) {
            if (b.getId() == bookId) {
                return b; // Return book if found
            }
        }
        return null; // Return null if not found
    }

    // Searches for a user in the list by their ID
    private User findUserById(int userId) {
        for (User u : listUser) {
            if (u.getUserId() == userId) {
                return u; // Return user if found
            }
        }
        return null; // Return null if not found
    }

    // Issues a book to a user
    public void issueBook(int bookId, int userId) {
        Book book = findBookById(bookId); // Get the book
        User user = findUserById(userId); // Get the user

        // If book or user is not found, show error
        if (book == null || user == null) {
            System.out.println("Book or User not found.");
            return;
        }

        // If book is already issued, show error
        if (book.isIssued()) {
            System.out.println("Book already issued.");
            return;
        }

        // Set book status to issued and add to user's borrowed list
        book.setIssued(true);
        user.borrowBook(book);
        System.out.println("Book issued successfully to " + user.getUserName());
    }

    // Returns a book from a user
    public void returnBook(int bookId, int userId) {
        Book book = findBookById(bookId);   // Get the book
        User user = findUserById(userId);   // Get the user

        // If book or user is not found, show error
        if (book == null || user == null) {
            System.err.println("Book or User not found.");
            return;
        }

        // If book is not issued or wasn't borrowed by this user, show error
        if (!book.isIssued() || !user.getBookList().contains(book)) {
            System.err.println("Book was not borrowed by this user.");
            return;
        }

        // Set book status to not issued and remove from user's list
        book.setIssued(false);
        user.returnBook(book);
        System.out.println("Book returned successfully by " + user.getUserName());
    }

    // Displays all books that are currently available
    public void displayAvailableBooks() {
        for (Book book : listBook) {
            if (!book.isIssued()) {
                System.out.println(book); // Book is available
            }
        }
    }

    // Displays user details based on user ID
    public void displayUserDetails(int userId) {
        User user = findUserById(userId);
        if (user != null) {
            System.out.println(user); // Show user details
        } else {
            System.out.println("User not found.");
        }
    }

    // Main method to run the library system
    public static void main(String[] args) {

        // Create Library object
        Library library = new Library();

        // Add some books to the library
        library.addBook(new Book(1, "Head First Java"));
        library.addBook(new Book(2, "History"));
        library.addBook(new Book(3, "Java Programming"));

        // Register user 1
        System.out.println("Enter the user name: ");
        String userName = sc.nextLine();
        library.addUser(new User(userName, 100));

        // Register user 2
        System.out.println("Enter the other user name: ");
        String userName2 = sc.nextLine();
        library.addUser(new User(userName2, 101));

        // Display books that are available
        System.out.println("Available Books:");
        library.displayAvailableBooks();
        System.out.println("\n");

        // Ask user to issue a book
        System.out.println("Enter the book id that you want to issue");
        int bookIssueId = sc.nextInt();
        System.out.println("Enter your id for issuing the book");
        int userIssueId = sc.nextInt();
        library.issueBook(bookIssueId, userIssueId);

        // Try issuing the same book again (should fail)
        System.out.println("Enter the book id that you want to issue");
        int bookIssueId2 = sc.nextInt();
        System.out.println("Enter your id for issuing the book");
        int userIssueId2 = sc.nextInt();
        library.issueBook(bookIssueId2, userIssueId2);
        System.out.println("\n");

        // Ask user to return a book
        System.out.println("Enter book id to return the book");
        int returnBookId = sc.nextInt();
        System.out.println("Enter your id to return the book");
        int returnUserId = sc.nextInt();
        library.returnBook(returnBookId, returnUserId);
        System.out.println("\n");

        // Show user details after operations
        library.displayUserDetails(returnUserId);
        System.out.println("\n");

        // Display books available after issue/return
        System.out.println("Available Books after operations:");
        library.displayAvailableBooks();
    }
}
