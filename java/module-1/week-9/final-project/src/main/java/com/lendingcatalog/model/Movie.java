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

public class Movie implements CatalogItem{
    private String id;
    private String name;
    private String director;
    private LocalDate releaseDate;

    //Constructor
    public Movie(String name, String director, LocalDate releaseDate) {
        this.name = name;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    //getters
    public String getId() {
        return this.id;
    }

    public void setId() {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    //    Methods:

    @Override
    public boolean matchesName(String searchStr) {
        String searchStrToUpperCase = searchStr.toUpperCase();
        String movieNameToUpperCase = name.toUpperCase();
        if (movieNameToUpperCase.contains(searchStrToUpperCase)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        String searchStrToUpperCase = searchStr.toUpperCase();
        String directorToUpperCase = director.toUpperCase();
        if (directorToUpperCase.contains(searchStrToUpperCase)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean matchesYear(int searchYear) {
        int releaseYear = releaseDate.getYear(); //gets year of release date
        return releaseYear == searchYear;
    }

    @Override
    public void registerItem() throws FileStorageException {
        //Assign unique ID to ID field
        id = UUID.randomUUID().toString();
        //Write message to log file that indicates book was created
        File movieLog = new File("resources/logs/MovieLog");
        String logPath = "src/main/resources/logs/MovieLog";

        FileStorageService.writeContentsToFile(toString(),logPath,true);
//        try (PrintWriter writer = new PrintWriter(new FileOutputStream(movieLog,true))) {
//            writer.println("\n" + "Movie Title: " + name
//                    + "\n" + "Directed by: " + director
//                    + "\n" + "Released Date: " + releaseDate
//                    + "\n" + "Id: " + id);
//            writer.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("Unable to create log: " + e);
//        }
    }

    @Override
    public String toString() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return
        localDateTime +
        "* " + name + System.lineSeparator()
        + " - Directed by: " + director + System.lineSeparator()
        + " - Released: " + releaseDate + System.lineSeparator()
        + " - Id: " + id;
    }

}
