package com.lendingcatalog.model;

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


    //***NEED TO COMPLETE BOTH BELOW

    public Void CatalogItem(boolean matchesType, boolean matchesManufacturer) {
//        if (matchesType && matchesManufacturer) {
//            return tool;
//        }
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
