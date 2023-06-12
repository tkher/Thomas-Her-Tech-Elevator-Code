package com.lendingcatalog.model;

public class Tool {
    private String id;
    private String type;
    private String manufacturer;
    private int count;

//Variables
//String id
//String type
//String manufacturer
//int count

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

//    @Override
    //***NEED TO COMPLETE BOTH BELOW
    public Void CatalogItem() {
        return null;
    }

    public String toString() {
        return null;
    }




}
