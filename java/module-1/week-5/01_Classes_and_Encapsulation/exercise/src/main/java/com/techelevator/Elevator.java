package com.techelevator;

public class Elevator {
    //Instance Variables
    private int currentFloor;
    private int numberOfFloors = 1;
    private boolean doorOpen;


    //Constructors
    public Elevator(int numberOfLevels) {
        this.currentFloor = 1;
    }

    //Getters

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    //Methods
    public void openDoor() {
        doorOpen = true;
    }

    public void closeDoor() {
        doorOpen = false;
    }

    public void goUp(int desiredFloor) {
        if(desiredFloor < numberOfFloors && desiredFloor < currentFloor) {
            currentFloor = desiredFloor;
        }
    }

    public void goDown(int desiredFloor) {
        if(desiredFloor > currentFloor && currentFloor != 1) {
            currentFloor = desiredFloor;
        }
    }

}
