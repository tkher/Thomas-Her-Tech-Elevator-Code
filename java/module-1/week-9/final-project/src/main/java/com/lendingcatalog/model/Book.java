package com.lendingcatalog.model;

import com.lendingcatalog.util.FileStorageService;
import com.lendingcatalog.util.exception.FileStorageException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public void setId(String id) {
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
    public void registerItem() throws FileStorageException {
        //Assign unique ID to ID field
        id = UUID.randomUUID().toString();
        //Write message to log file that indicates book was created ***I think this works?
        String logPath = "src/main/resources/logs/BookLog";
        File bookLog = new File(logPath);

        FileStorageService.writeContentsToFile(/*local*/ toString(),logPath, true );
           //call in local date and time prior to toString() in method
    }



    @Override
    public String toString() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return
        localDateTime +
        //or put in local date/time here vs in register item method
        "* " + title + System.lineSeparator()
        + " - Written by: " + author +System.lineSeparator()
        + " - Published: " + publishDate + System.lineSeparator()
        + " - Id: " + id;
    }
}
