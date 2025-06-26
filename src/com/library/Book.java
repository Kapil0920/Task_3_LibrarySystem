package com.library;

public class Book {

    // Unique ID for the book
    private int id;

    // Title or name of the book
    private String title;

    // Status to check whether the book is issued or not
    private boolean isIssued;

    // Getter method to get the book's ID
    public int getId() {
        return id;
    }

    // Getter method to get the book's title
    public String getTitle() {
        return title;
    }

    // Setter method to update the issued status of the book (true = issued, false = available)
    public void setIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }

    // Getter method to check whether the book is issued
    public boolean isIssued() {
        return isIssued;
    }

    // Constructor to initialize book object with ID and title
    public Book(int id, String title) {
        super(); // Calls the constructor of the parent class (Object class), not required explicitly but fine to use
        this.id = id;
        this.title = title;
    }

    // Overridden toString method to return a string representation of the book object
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + "]";
    }
}
