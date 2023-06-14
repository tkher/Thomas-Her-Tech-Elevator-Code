package com.lendingcatalog.model;

import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.UUID;

public class Book implements CatalogItem {
    private String id;
    private String title;
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

    //This setter may not be needed
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
    @Override
    public boolean matchesName(String searchStr) {
        String searchStrToUpperCase = searchStr.toUpperCase();
        String bookTitleToUpperCase = title.toUpperCase();
        if (bookTitleToUpperCase.contains(searchStrToUpperCase)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        String searchStrToUpperCase = searchStr.toUpperCase();
        String authorToUpperCase = author.toUpperCase();
        if (authorToUpperCase.contains(searchStrToUpperCase)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean matchesYear(int searchYear) {
        int publishedYear = publishDate.getYear(); //gets year of local date.
        return publishedYear == searchYear; //if publishedYear == searchYear, return true - else return false.
    }

    @Override
    public void registerItem() {
        //Assign unique ID to ID field
        id = UUID.randomUUID().toString();
        //Write message to log file that indicates book was created
        File bookLog = new File("resources/logs/BookLog"); //will be in next steps file IO
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
