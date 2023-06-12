package com.lendingcatalog.model;

import java.time.LocalDate;

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

    public CatalogItem() {
        return null;
    }

    @Override
    public String toString() {
        return
        "* " + name + System.lineSeparator()
        + " - Directed by: " + director + System.lineSeparator()
        + " - Released: " + releaseDate + System.lineSeparator()
        + " - Id: " + id;
    }

}
