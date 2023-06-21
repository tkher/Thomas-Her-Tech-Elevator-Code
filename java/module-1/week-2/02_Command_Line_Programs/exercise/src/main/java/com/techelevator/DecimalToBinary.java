package com.techelevator;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DecimalToBinary {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter in a series of decimal values (separated by spaces): ");
        String userInput = input.nextLine();
        String[] listOfuserInput = userInput.split(" ");
        int decimalValues = 0;

        System.out.print(listOfuserInput[0] + " in binary is ");

        for (int i = 0; i <= listOfuserInput.length; i++) {
            decimalValues = Integer.parseInt(listOfuserInput[i]);
            for (int a = 0; a <= decimalValues; a ++) {
                if (decimalValues % 2 == 0) {
                    decimalValues = decimalValues / 2;
                    System.out.print("0");
                } else {
                    System.out.println("");
                }
            }


            //for (int i = 0; i <listOfValues.length; i++) {
            //	listOfValues[i] =
            //}

        }

    }
}