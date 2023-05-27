package com.techelevator;

public class SquareWall extends RectangleWall{
    private int sideLength;

    //constructor
    public SquareWall(String name, String color, int sideLength){
        super(name,color);
        this.sideLength = sideLength;
    }

    //getters
    public int getSideLength() {
        return sideLength;
    }

    public int getArea() {
        return sideLength*sideLength;
    }

    //methods
    public String toString() {
        return getName() +" (" +sideLength+"x"+sideLength+ ") "+ "square";
    }
}
