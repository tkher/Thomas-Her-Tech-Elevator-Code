package com.techelevator;

public class TriangleWall extends Wall{
    private int base;
    private int height;

    //con
    public TriangleWall(String name, String color, int base, int height) {
        super(name,color);
        this.base=base;
        this.height=height;
    }

    //getters
    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }
    // methods


    @Override
    public int getArea() {
        return (base*height)/2;
    }

    @Override
    public String toString() {
        return getName() +" (" +base+"x"+height+ ") "+ "triangle";
    }
}
