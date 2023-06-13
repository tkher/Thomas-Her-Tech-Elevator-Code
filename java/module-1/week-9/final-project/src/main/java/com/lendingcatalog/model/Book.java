package com.lendingcatalog.model;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.UUID;

public class Book implements CatalogItem {
    private String id;
    private static String title; //should this be static??
    private String author;
    private LocalDate publishDate;

    //Constructor
    public Book(String title, String author, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
    }

    //getters
    public String getId() {
        return this.id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public LocalDate getPublishDate() {
        return this.publishDate;
    }

//      Methods:
//     CatalogItem interface
    public boolean matchesName(String searchStr) {
        String searchStrToUpperCase = searchStr.toUpperCase();
        String bookTitleToUpperCase = Book.title.toUpperCase();
        if (bookTitleToUpperCase.contains(searchStrToUpperCase)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchesCreator(String searchStr) {
        String searchStrToUpperCase = searchStr.toUpperCase();
        String authorToUpperCase = Book.author.toUpperCase(); //if variable is not static??
        if (authorToUpperCase.contains(searchStrToUpperCase)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchesYear(int searchYear) {
        int publishedYear = publishDate.getYear(); //Book.publishDate??
        return publishedYear == searchYear; //if publishedYear == searchYear, return true - else return false.
    }

    public void registerItem() {
        //Assign unique ID to ID field
        Book.id = UUID.randomUUID().toString();
        //Write message to log file that indicates book was created
        File bookLog = new File("resources/logs/BookLog.txt");
    }



    @Override
    public String toString() {
        return
        "* " + title + System.lineSeparator()
        + " - Written by: " + author +System.lineSeparator()
        + " - Published: " + publishDate + System.lineSeparator()
        + " - Id: " + id;
    }
}
