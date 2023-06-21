package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    // DO NOT REMOVE the DEFAULT_NUMBER_OF_... constants!!!!!
    public static final int DEFAULT_NUMBER_OF_COMPACT_SLOTS = 3;
    public static final int DEFAULT_NUMBER_OF_MIDSIZE_SLOTS = 5;
    public static final int DEFAULT_NUMBER_OF_FULLSIZE_SLOTS = 2;

    /*
    Fill in the class details here...
     */
    //Attributes
    private String name;
    private boolean open;
    private int numberOfCompactSlots = DEFAULT_NUMBER_OF_COMPACT_SLOTS;
    private int numberOfMidsizeSlots = DEFAULT_NUMBER_OF_MIDSIZE_SLOTS;
    private int numberOfFullsizeSlots = DEFAULT_NUMBER_OF_FULLSIZE_SLOTS;

    //3 public constructors
    public ParkingLot(String name) {
        this.name = name;
        isOpen();
        getNumberOfCompactSlots();
        getNumberOfFullsizeSlots();
        getNumberOfMidsizeSlots();
    }

    public ParkingLot(String name, boolean open){
        this.name = name;
        this.open = open;
        getNumberOfCompactSlots();
        getNumberOfFullsizeSlots();
        getNumberOfMidsizeSlots();
    }

    public ParkingLot(String name, boolean open, int numberOfCompactSlots, int numberOfMidsizeSlots, int numberOfFullsizeSlots) {
        this.name = name;
        this.open = open;
        this.numberOfCompactSlots = numberOfCompactSlots;
        this.numberOfMidsizeSlots = numberOfMidsizeSlots;
        this.numberOfFullsizeSlots = numberOfFullsizeSlots;
    }

    //Getters and setters
    public String getName() {
        return name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getNumberOfCompactSlots() {
        return numberOfCompactSlots;
    }

    public int getNumberOfMidsizeSlots() {
        return numberOfMidsizeSlots;
    }

    public int getNumberOfFullsizeSlots() {
        return numberOfFullsizeSlots;
    }

    //Methods

    public int getLotSize() {
        return 0;
    }

    public int numberOfAvailableSlots (String carType) {
        return 0;
    }

    public boolean park(Car car) {
        return false;
    }

    public Car exit(String carType, String license) {
        Car exitingCar = new Car("","");
        return exitingCar;
    }

}
