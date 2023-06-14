package com.lendingcatalog.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.UUID;

public class Tool implements CatalogItem{
    private String id;
    private String type;
    private String manufacturer;
    private int count;


    //Constructor:
    public Tool (String type, String manufacturer, int count) {
        //No id in constructor? this.id = id;
        this.type = type;
        this.manufacturer = manufacturer;
        this.count = count;
    }

    //getters
    public String getId() {
        return this.id;
    }

    public void setId() {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public int getCount() {
        return this.count;
    }

    //Methods

    @Override
    public boolean matchesName(String searchStr) {
        String searchStrToUpperCase = searchStr.toUpperCase();
        String toolTypeToUpperCase = type.toUpperCase();
        if (toolTypeToUpperCase.contains(searchStrToUpperCase)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean matchesCreator(String searchStr) {
        String searchStrToUpperCase = searchStr.toUpperCase();
        String manufacturerToUpperCase = manufacturer.toUpperCase();
        if (manufacturerToUpperCase.contains(searchStrToUpperCase)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    //no year field - returns false
    public boolean matchesYear(int searchYear) {
        return false;
    }

    @Override
    public void registerItem() {
        //Assign unique ID to ID field
        id = UUID.randomUUID().toString();
        //Write message to log file that indicates book was created
        File toolLog = new File("resources/logs/ToolLog");

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(toolLog,true))) {
            writer.println("\n" + "Tool type: " + type
                    + "\n" + "Manufactured by: " + manufacturer
                    + "\n" + "Id: " + id);
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Unable to create log: " + e);
        }
    }

    @Override
    public String toString() {
        return
        "* " + type + System.lineSeparator()
        + " - Manufactured by: " + manufacturer + System.lineSeparator()
        + " - Count of: " + count + System.lineSeparator()
        + " - Id: " + id;
    }




}
