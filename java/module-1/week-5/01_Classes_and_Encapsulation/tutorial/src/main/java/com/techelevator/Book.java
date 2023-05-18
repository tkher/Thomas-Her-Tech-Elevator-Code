package com.techelevator;

public class Book {

    //Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book() {

    }

    //Add the instance variables
    private String title;
    private String author;
    private double price;

    //getter for title instance variable
    public String getTitle() {
        return title;
    }

    //setter for title instance variable
    public void setTitle(String title) {
        this.title = title;
    }

    //getter and setter for author instance variable
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    //getter and setter for price instance variable
    public double getPrice () {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //bookInfo method

    public String bookInfo() {
        return "Title: " + title + ", Author: " + author + ", Price: " + price;
    }

}

