package com.techelevator;

public class Airplane {
    //Instance variables
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

    //Constructor
    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    //Getters
    public int getAvailableFirstClassSeats() {
        return this.totalFirstClassSeats - bookedCoachSeats;
    }

    public int getAvailableCoachSeats() {
        return this.totalCoachSeats - bookedCoachSeats;

    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    //Methods
    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        if (forFirstClass) {
            if (totalNumberOfSeats > (this.totalFirstClassSeats - bookedCoachSeats)) {
                this.bookedFirstClassSeats = bookedFirstClassSeats + totalNumberOfSeats;
                forFirstClass = true;
            } else {
                forFirstClass = false;
            }
        } else {
            if (totalNumberOfSeats > (this.totalCoachSeats - bookedCoachSeats)) {
                this.bookedCoachSeats = bookedCoachSeats + totalNumberOfSeats;
                forFirstClass = true;
            } else {
                forFirstClass = false;
            }


        }
        return forFirstClass;
    }

}

