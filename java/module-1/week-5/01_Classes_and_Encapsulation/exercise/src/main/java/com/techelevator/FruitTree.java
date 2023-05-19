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
    public String getTypeOfFruit() { return typeOfFruit;}

    public int getPiecesOfFruitLeft() { return piecesOfFruitLeft;}

//    public int getStartingPiecesOfFruit() { return startingPiecesOfFruit;}

    //methods
    public boolean pickFruit (int numberOfPiecesToRemove) {
        //need more logic
        if ((piecesOfFruitLeft - numberOfPiecesToRemove) >=0) {
            piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
            return true;
        }else{
            return false;
        }
    }
}
