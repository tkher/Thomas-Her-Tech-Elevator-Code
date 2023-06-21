package com.techelevator;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter in a series of decimal values (separated by spaces): ");
        String userInput = input.nextLine();
//        String[] listOfuserInput = userInput.split(" ");
        int decimalNumber = Integer.parseInt(userInput);

//        System.out.print(listOfuserInput[0] + " in binary is ");
        //Grab first input value
//        for (int i = 0; i <= listOfuserInput.length; i++) {
//            decimalNumber = Integer.parseInt(listOfuserInput[i]);


        //determine size of binary number to create array
        int arrayCounter = 0;
        int newDecimalNumber = 0;
        while (decimalNumber % 2 == 0) {
            decimalNumber = decimalNumber / 2;
            arrayCounter++;
        }

        //create Array to hold binary number, needs to add 1 for remainder value
        int[] binaryNumberList = new int[arrayCounter + 1];

        //loop through decimalNumber to till reaches remainder
        for (int b = 0; b < binaryNumberList.length; b++) {
            if (decimalNumber / 2 == 0) {
                binaryNumberList[b] = (decimalNumber % 2);
                decimalNumber = decimalNumber / 2;
            }

            //print out array via loop
            for (int c = 0; c < binaryNumberList.length; c++)
                System.out.println(binaryNumberList[c]);
        }

    }
}


