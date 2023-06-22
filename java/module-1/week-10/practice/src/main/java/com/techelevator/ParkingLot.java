package com.techelevator;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    Map<String,String> listOfParkedCars = new HashMap<String, String>();


    //3 public constructors
    public ParkingLot(String name) {
        this.name = name;

    }

    public ParkingLot(String name, boolean open) {
        this.name = name;
        this.open = open;

    }

    public ParkingLot(String name, boolean open, int numberOfCompactSlots, int numberOfMidsizeSlots, int numberOfFullsizeSlots) {
        this.name = name;
        this.open = open;
        this.numberOfCompactSlots = numberOfCompactSlots;
        this.numberOfMidsizeSlots = numberOfMidsizeSlots;
        this.numberOfFullsizeSlots = numberOfFullsizeSlots;
    }



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


    //Required Methods
    public int getLotSize() {
        return numberOfCompactSlots + numberOfMidsizeSlots + numberOfFullsizeSlots;
    }

    public int
    //my number of available slots is not counting correctly
    public int numberOfAvailableSlots(String carType) {
        //Find how many parked car there are in listOfParkedCars per each type
        int parkedCompactCounter = 0;
        int parkedMidsizeCounter = 0;
        int parkedFullsizeCounter = 0;
        for (String i : listOfParkedCars.keySet()) {
            if (listOfParkedCars.get(i).equalsIgnoreCase("compact")) {
                parkedCompactCounter++;
            } else if (listOfParkedCars.get(i).equalsIgnoreCase("midsize")) {
                parkedMidsizeCounter++;
            } else {
                parkedFullsizeCounter++;
            }
        }

        int countOfSlots = 0;
        if (carType.equalsIgnoreCase("compact")) {
            countOfSlots = getNumberOfCompactSlots() - parkedCompactCounter;
        } else if (carType.equalsIgnoreCase("midsize")) {
            countOfSlots = getNumberOfMidsizeSlots() - parkedMidsizeCounter;
        } else {
            countOfSlots = getNumberOfFullsizeSlots() - parkedFullsizeCounter;
        }
        return countOfSlots;
    }

    public boolean park(Car car) {
        if (car.getType().equalsIgnoreCase("compact")) {
            listOfParkedCars.put(car.getLicense(),car.getType());
            return numberOfAvailableSlots(car.getType()) < getNumberOfCompactSlots();
        } else if (car.getType().equalsIgnoreCase("midsize")) {
            listOfParkedCars.put(car.getLicense(),car.getType());
            return numberOfAvailableSlots(car.getType()) < getNumberOfMidsizeSlots();
        } else {
            listOfParkedCars.put(car.getLicense(),car.getType());
            return numberOfAvailableSlots(car.getType()) < getNumberOfFullsizeSlots();
        }
    }


    public Car exit(String carType, String license) {
        Car searchCar = new Car(carType, license);
        if (listOfParkedCars.containsKey(license)) {
            listOfParkedCars.remove(license);
            return searchCar;
        } else {
            return null;
        }
    }

}
