package com.techelevator;

public class HotelReservation {
    private String name;
    private int numberOfNights;
    private int nightlyRate;
    private int estimatedTotal;

    //Constructor
    public HotelReservation(String name, int numberOfNights, int nightlyRate) {
        this.name = name;
        this.numberOfNights = numberOfNights;
        this.nightlyRate = nightlyRate;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public int getNightlyRate() {
        return nightlyRate;
    }

    public void setNightlyRate(int nightlyRate) {
        this.nightlyRate = nightlyRate;
    }

    public int getEstimatedTotal() {
        return numberOfNights * nightlyRate;
    }

    //methods
    public int getActualTotal(boolean requiresCleaning, boolean usedMinibar) {
        int finalBill = getEstimatedTotal();
        int cleaningFee = 25;
        if(usedMinibar) {
            finalBill += 15;
            cleaningFee = cleaningFee * 2;
        }
        if(requiresCleaning) {
            finalBill += cleaningFee;
        }
        return finalBill;
    }


    //toString
    @Override
    public String toString() {
        return name + ":" + getEstimatedTotal();
    }

}
