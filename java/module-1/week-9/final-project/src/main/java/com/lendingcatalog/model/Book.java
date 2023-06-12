package com.lendingcatalog.model;

import java.io.PrintWriter;
import java.time.LocalDate;

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
    public String CatalogItem(boolean matchesName,boolean matchesCreator, boolean matchesYear) {
        if (matchesName && matchesCreator && matchesYear) {

            return title + " has been added to the catalog";
        }//*** include time/date added and properties of the item. must be seperate logs -
        //return writes messge to log file, does not print message.
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
