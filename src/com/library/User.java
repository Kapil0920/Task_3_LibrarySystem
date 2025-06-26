package com.library;

import java.util.ArrayList;

public class User {

    // Name of the user
    private String userName;

    // Unique ID assigned to the user
    private int userId;

    // List of books borrowed by the user
    private ArrayList<Book> bookList;

    // Getter method to return the user's name
    public String getUserName() {
        return userName;
    }

    // Getter method to return the user's ID
    public int getUserId() {
        return userId;
    }

    // Getter method to return the list of books the user has borrowed
    public ArrayList<Book> getBookList() {
        return bookList;
    }

    // Method to return a book (remove it from the user's borrowed book list)
    public void returnBook(Book returnBook) {
        bookList.remove(returnBook);
    }

    // Method to borrow a book (add it to the user's borrowed book list)
    public void borrowBook(Book borrowBook) {
        bookList.add(borrowBook);
    }

    // toString method to return a string representation of the user object
    @Override
    public String toString() {
        return "User [userName=" + userName + ", userId=" + userId + ", bookList=" + bookList + "]";
    }

    // Constructor to initialize the user with a name and ID
    public User(String userName, int userId) {
        super(); // Calls the parent class constructor (Object class)
        this.userName = userName;
        this.userId = userId;
        this.bookList = new ArrayList<Book>(); // Initializes the user's borrowed book list
    }
}
