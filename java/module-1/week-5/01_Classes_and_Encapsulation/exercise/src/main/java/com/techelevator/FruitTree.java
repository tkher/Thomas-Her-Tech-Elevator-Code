package com.techelevator;

public class FruitTree {
    //Instance Variables
    private String typeOfFruit;
    private int piecesOfFruitLeft;
//    private int startingPiecesOfFruit;

    //Constructor
    public FruitTree(String typeOfFruit,int startingPiecesOfFruit) {
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = startingPiecesOfFruit;
    }

    //Getters and Setters
    public String getTypeOfFruit() { return getTypeOfFruit();}

    public int getPiecesOfFruitLeft() { return getPiecesOfFruitLeft();}

//    public int getStartingPiecesOfFruit() { return startingPiecesOfFruit;}

    //methods
    public boolean pickFruit (int numberOfPiecesToRemove) {
        //need more logic
        if (numberOfPiecesToRemove >= piecesOfFruitLeft) {
            return true;
        }else{
            return false;
        }
    }
}
